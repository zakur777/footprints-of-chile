package com.programadorescl.medicalconsultation.domain.gateways;


import com.programadorescl.medicalconsultation.domain.entities.PetConsultation;

import java.util.List;
import java.util.Optional;

public interface PetConsultationGateway {
    Optional<PetConsultation> findById(int id);

    List<PetConsultation> getAll();

    PetConsultation update(PetConsultation petConsultation);

    PetConsultation save(PetConsultation petConsultation);

    void delete(PetConsultation petConsultation);
}
