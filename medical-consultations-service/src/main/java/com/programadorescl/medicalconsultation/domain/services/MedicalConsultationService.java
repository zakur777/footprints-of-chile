package com.programadorescl.medicalconsultation.domain.services;

import com.programadorescl.medicalconsultation.domain.entities.MedicalConsultation;
import com.programadorescl.medicalconsultation.domain.entities.Pet;
import com.programadorescl.medicalconsultation.domain.entities.User;
import com.programadorescl.medicalconsultation.domain.exception.ConsultOpenOrTreatmentException;
import com.programadorescl.medicalconsultation.domain.exception.OpenConsultException;
import com.programadorescl.medicalconsultation.domain.exception.OtherPetConsultationnException;
import com.programadorescl.medicalconsultation.domain.gateways.MedicalConsultationGateway;
import com.programadorescl.medicalconsultation.domain.gateways.PetConsultationGateway;
import com.programadorescl.medicalconsultation.domain.gateways.PetGateway;
import com.programadorescl.medicalconsultation.domain.gateways.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalConsultationService {
    @Autowired
    private MedicalConsultationGateway medicalConsultationGateway;

    @Autowired
    private PetGateway petGateway;

    @Autowired
    private PetConsultationGateway petConsultationGateway;

    @Autowired
    private UserGateway userGateway;


    public List<MedicalConsultation> getAll() {
        return medicalConsultationGateway.getAll();
    }

    public Optional<MedicalConsultation> findById(int id) {
        return medicalConsultationGateway.findById(id);
    }

    public MedicalConsultation save(MedicalConsultation medicalConsultation) throws OpenConsultException, OtherPetConsultationnException {

        boolean consulta1 = medicalConsultationGateway.existsByStatusMedicalConsultationContainingIgnoreCaseAndPetId("abierta", medicalConsultation.getPetId());
        Object[] args = {medicalConsultation};

        if (consulta1) {
            throw new OpenConsultException("consulta.consultopen.message", args);
        }


        boolean existPet = medicalConsultationGateway.existsByPetIdAndIdPetConsultation(medicalConsultation.getPetId(),
                medicalConsultation.getIdPetConsultation());

        if (existPet) {
            throw new OtherPetConsultationnException("consulta.otherpetCosultationn.message", args);
        }

        //TODO FETCH A LA OTRA API PET_USER
        Optional<Pet> pet = petGateway.findById(medicalConsultation.getPetId());

        //TODO FETCH A LA OTRA API PET_USER 2
        Optional<MedicalConsultation> petCosultation = medicalConsultationGateway.findById(medicalConsultation.getIdPetConsultation());

        //TODO FETCH A LA OTRA API PET_USER 3
        Optional<User> user = userGateway.findById(medicalConsultation.getUserId());

        return medicalConsultationGateway.save(medicalConsultation);
    }

    public MedicalConsultation update(int id, MedicalConsultation medicalConsultation) {
        //TODO FETCH A LA OTRA API PET_USER
        Optional<MedicalConsultation> optionalMedicalConsultation = medicalConsultationGateway.findById(id);

        //TODO FETCH A LA OTRA API PET_USER
        Optional<Pet> pet = petGateway.findById(medicalConsultation.getPetId());

        //TODO FETCH A LA OTRA API PET_USER
        Optional<User> user = userGateway.findById(medicalConsultation.getUserId());

        return medicalConsultationGateway.update(medicalConsultation);
    }

    public MedicalConsultation estadoCerrada(int id) {
        Optional<MedicalConsultation> medicalConsultation = medicalConsultationGateway.findById(id);

        Optional<Pet> pet = petGateway.findById(medicalConsultation.get().getPetId());

        Optional<User> user = userGateway.findById(medicalConsultation.get().getUserId());


        if (medicalConsultation.get().isIsTreatment()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tratamiento esta activo");
        }

        if (medicalConsultation.get().getTotalAmount() != 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El valor del tratamiento no esta cancelado");
        }

        return medicalConsultationGateway.update(medicalConsultation.get());
    }

    public MedicalConsultation tratamientoTerminado(int id) {
        Optional<MedicalConsultation> medicalConsultation = medicalConsultationGateway.findById(id);

        Optional<Pet> pet = petGateway.findById(medicalConsultation.get().getPetId());

        Optional<User> user = userGateway.findById(medicalConsultation.get().getUserId());

        return medicalConsultationGateway.update(medicalConsultation.get());
    }

    public MedicalConsultation tratamientoPagado(int id) {
        Optional<MedicalConsultation> medicalConsultation = medicalConsultationGateway.findById(id);

        Optional<Pet> pet = petGateway.findById(medicalConsultation.get().getPetId());

        Optional<User> user = userGateway.findById(medicalConsultation.get().getUserId());

        return medicalConsultationGateway.update(medicalConsultation.get());
    }

    public MedicalConsultation enTratamiento(int id) {
        Optional<MedicalConsultation> medicalConsultation = medicalConsultationGateway.findById(id);

        Optional<Pet> pet = petGateway.findById(medicalConsultation.get().getPetId());

        Optional<User> user = userGateway.findById(medicalConsultation.get().getUserId());

        return medicalConsultationGateway.update(medicalConsultation.get());
    }

    public void delete(int id) throws ConsultOpenOrTreatmentException {
        Optional<MedicalConsultation> consulta1 = medicalConsultationGateway.findById(id);

        String status = consulta1.get().getStatusMedicalConsultation();

        if (status.equals("en tratamiento") || status.equals("abierta")) {
            Object[] args = {id};
            throw new ConsultOpenOrTreatmentException("consulta.opentreatment.message", args);
        }

        medicalConsultationGateway.findById(id).map(consulta -> {
            medicalConsultationGateway.delete(consulta);
            return true;
        });
    }
}
