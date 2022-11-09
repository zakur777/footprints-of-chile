package com.programadorescl.medicalconsultation.domain.gateways;

import com.programadorescl.medicalconsultation.domain.entities.MedicalConsultation;
import com.programadorescl.medicalconsultation.domain.entities.StatusMedicalConsultation;

import java.util.List;
import java.util.Optional;

public interface MedicalConsultationGateway {

    Optional<MedicalConsultation> findById(Long id);

    List<MedicalConsultation> getAll();

    // boolean existsByStatusMedicalConsultationContainingAndPetName(String estado, String petName);

    // boolean existsByPetNameAndIdPetConsultation(String petName, Long idPetConsultation);

    Optional<Long> countPetNameAndStatusMedicalConsultation(String petName);

    MedicalConsultation save(MedicalConsultation medicalConsultation);


    void delete(MedicalConsultation medicalConsultation);

    MedicalConsultation update(MedicalConsultation medicalConsultation);
}
