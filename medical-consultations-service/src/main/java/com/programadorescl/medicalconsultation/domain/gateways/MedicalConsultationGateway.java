package com.programadorescl.medicalconsultation.domain.gateways;

import com.programadorescl.medicalconsultation.domain.entities.MedicalConsultation;

import java.util.List;
import java.util.Optional;

public interface MedicalConsultationGateway {

    Optional<MedicalConsultation> findById(int id);

    List<MedicalConsultation> getAll();

    boolean existsByStatusMedicalConsultationContainingIgnoreCaseAndPetId(String estado, int id);

    boolean existsByPetIdAndIdPetConsultation(int idPet, int idPetConsultation);

    MedicalConsultation save(MedicalConsultation medicalConsultation);

    void delete(MedicalConsultation medicalConsultation);

    MedicalConsultation update(MedicalConsultation medicalConsultation);
}
