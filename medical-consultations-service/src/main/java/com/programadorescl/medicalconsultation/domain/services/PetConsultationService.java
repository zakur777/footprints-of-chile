package com.programadorescl.medicalconsultation.domain.services;

import com.programadorescl.medicalconsultation.domain.entities.PetConsultation;
import com.programadorescl.medicalconsultation.domain.gateways.PetConsultationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetConsultationService {

    @Autowired
    private PetConsultationGateway gateway;

    public List<PetConsultation> getAll() {
        return gateway.getAll();
    }

    public Optional<PetConsultation> findById(int id) {
        return gateway.findById(id);
    }

    public PetConsultation save(PetConsultation petConsultation) {
        return gateway.save(petConsultation);
    }

    /*
    public PetConsultation update(int id, RequestPetConsultationDTO dto) {

        Optional<PetConsultation> veterinaria1 = gateway.findById(id);

        if(veterinaria1.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PetConsultation no existe");
        }

        PetConsultation veterinaria = new PetConsultation();

        veterinaria.setIdPetConsultation(id);
        veterinaria.setNombre(dto.getNombre());

        return gateway.updatePetConsultation(veterinaria);
    }
    */

    public PetConsultation update(PetConsultation petConsultation) {
        return gateway.update(petConsultation);
    }

    public void deletePetConsultation(int id) {
        gateway.findById(id).map(veterinaria -> {
            gateway.delete(veterinaria);
            return true;
        });
    }
}
