package com.programadorescl.medicalconsultation.domain.services;

import com.programadorescl.medicalconsultation.domain.entities.*;
import com.programadorescl.medicalconsultation.domain.exception.*;
import com.programadorescl.medicalconsultation.domain.gateways.MedicalConsultationGateway;
import com.programadorescl.medicalconsultation.persistence.dto.RequestPetConsultationDTO;
import com.programadorescl.medicalconsultation.persistence.dto.RequestPetDTO;
import com.programadorescl.medicalconsultation.persistence.dto.RequestUserDTO;
import com.programadorescl.medicalconsultation.persistence.mappers.PetConsultationMapper;
import com.programadorescl.medicalconsultation.persistence.mappers.PetMapper;
import com.programadorescl.medicalconsultation.persistence.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class MedicalConsultationService {

    @Autowired private MedicalConsultationGateway medicalConsultationGateway;

    private RestTemplate restTemplate;
    private PetMapper petMapper;

    private UserMapper userMapper;

    private PetConsultationMapper petConsultationMapper;

    @Autowired
    public MedicalConsultationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate =
                restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
    }

    public List<MedicalConsultation> getAll() throws Exception {
        return medicalConsultationGateway.getAll();
    }

    public Optional<MedicalConsultation> findById(Long id) throws Exception {
        Optional<MedicalConsultation> optionalMedicalConsultation = medicalConsultationGateway.findById(id);
        if (!optionalMedicalConsultation.isPresent()) {
            Object[] args = {id};
            throw new PetConsultationNotFoundException("petConsultationNotFound", args);
        }
        return medicalConsultationGateway.findById(id);
    }

    public MedicalConsultation save(MedicalConsultation medicalConsultation) throws Exception {

        validateTwoOpenMedicalConsultations(medicalConsultation);

        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", "VALOR");

        RequestPetDTO requestPetDTO = validatePet(medicalConsultation, pathVariables);
        Pet pet = new Pet();
        BeanUtils.copyProperties(requestPetDTO, pet);

        pathVariables.replace("id", medicalConsultation.getUserId().toString());
        RequestUserDTO requestUserDTO = validateUser(medicalConsultation, pathVariables);

        User user = new User();
        BeanUtils.copyProperties(requestUserDTO, user);

        pathVariables.replace("id", medicalConsultation.getIdPetConsultation());
        RequestPetConsultationDTO requestPetConsultationDTO =
                vavlidatePetConsultation(medicalConsultation, pathVariables);

        PetConsultation petConsultation = new PetConsultation();
        BeanUtils.copyProperties(requestPetConsultationDTO, petConsultation);

        medicalConsultation.setPet(pet);
        medicalConsultation.setUser(user);
        medicalConsultation.setPetConsultation(petConsultation);

        return medicalConsultationGateway.save(medicalConsultation);
    }

    public MedicalConsultation update(MedicalConsultation medicalConsultation) throws Exception {

        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", "VALOR");

        validateMedicalConsultation(medicalConsultation);
        validateUser(medicalConsultation, pathVariables);
        validatePet(medicalConsultation, pathVariables);
        vavlidatePetConsultation(medicalConsultation, pathVariables);

        boolean totalPaymentOk =
                medicalConsultation.getTotalAmount().equals(medicalConsultation.getPayment());

        if (!medicalConsultation.isTreatment() && totalPaymentOk) {
            medicalConsultation.setStatusMedicalConsultation(StatusMedicalConsultation.CLOSED);
        }

        return medicalConsultationGateway.update(medicalConsultation);
    }

    public void delete(Long id) throws Exception {

        Optional<MedicalConsultation> optionalMedicalConsultation = this.findById(id);
        if (!optionalMedicalConsultation.isPresent()) {
            Object[] args = {optionalMedicalConsultation.get().getId()};
            throw new MedicalConsultationNotFoundException("medicalConsultationNotFound", args);
        }

        StatusMedicalConsultation status =
                optionalMedicalConsultation.get().getStatusMedicalConsultation();

        if (status.equals(StatusMedicalConsultation.OPEN)
                || status.equals(StatusMedicalConsultation.UNDER_TREATMENT)) {
            Object[] args = {id};
            throw new ConsultOpenOrUnderTreatmentException("consultOpenOrUnderTreatment", args);
        }

        medicalConsultationGateway.delete(optionalMedicalConsultation.get());
    }

    private void validateMedicalConsultation(MedicalConsultation medicalConsultation)
            throws Exception {
        Optional<MedicalConsultation> optionalMedicalConsultation =
                this.findById(medicalConsultation.getId());
        if (!optionalMedicalConsultation.isPresent()) {
            Object[] args = {medicalConsultation.getId()};
            throw new MedicalConsultationNotFoundException("medicalConsultationNotFound", args);
        }
    }

    private RequestPetConsultationDTO vavlidatePetConsultation(
            MedicalConsultation medicalConsultation, Map<String, String> pathVariables)
            throws Exception {
        pathVariables.replace("id", medicalConsultation.getIdPetConsultation());
        RequestPetConsultationDTO requestPetConsultationDTO =
                restTemplate.getForObject(
                        "http://localhost:8080/v1/petConsultation/{id}",
                        RequestPetConsultationDTO.class,
                        pathVariables);
        if (isNull(requestPetConsultationDTO.getId())) {
            Object[] args = {medicalConsultation.getIdPetConsultation()};
            throw new PetConsultationNotFoundException("petConsultationNotFound", args);
        }
        return requestPetConsultationDTO;
    }

    private RequestUserDTO validateUser(
            MedicalConsultation medicalConsultation, Map<String, String> pathVariables)
            throws Exception {
        pathVariables.replace("id", medicalConsultation.getUserId().toString());
        RequestUserDTO requestUserDTO =
                restTemplate.getForObject(
                        "http://localhost:8050/v1/users/{id}", RequestUserDTO.class, pathVariables);
        if (isNull(requestUserDTO.getUserId())) {
            Object[] args = {medicalConsultation.getUserId()};
            throw new UserNotFoundException("userNotFound", args);
        }
        return requestUserDTO;
    }

    private RequestPetDTO validatePet(
            MedicalConsultation medicalConsultation, Map<String, String> pathVariables)
            throws Exception {
        pathVariables.replace("id", medicalConsultation.getPetName());
        RequestPetDTO requestPetDTO =
                restTemplate.getForObject(
                        "http://localhost:8050/v1/pets/{id}", RequestPetDTO.class, pathVariables);
        if (isNull(requestPetDTO.getName())) {
            Object[] args = {medicalConsultation.getPetName()};
            throw new PetNotFoundException("petNotFound", args);
        }
        return requestPetDTO;
    }

    private void validateTwoOpenMedicalConsultations(MedicalConsultation medicalConsultation)
            throws PethWithMedicalConsultationOpenException {
        Optional<Long> countOpenMedicalConsultation =
                medicalConsultationGateway.countPetNameAndStatusMedicalConsultation(
                        medicalConsultation.getPetName());

        if (countOpenMedicalConsultation.isPresent() && countOpenMedicalConsultation.get() == 2) {
            Object[] args = {medicalConsultation.getPetName()};
            throw new PethWithMedicalConsultationOpenException(
                    "pethWithMedicalConsultationOpen", args);
        }
    }
}
