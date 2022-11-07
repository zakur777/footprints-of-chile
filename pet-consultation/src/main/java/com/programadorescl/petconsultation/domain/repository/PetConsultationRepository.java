package com.programadorescl.petconsultation.domain.repository;

import com.programadorescl.petconsultation.domain.model.entity.PetConsultation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetConsultationRepository extends MongoRepository<PetConsultation, String> {
}
