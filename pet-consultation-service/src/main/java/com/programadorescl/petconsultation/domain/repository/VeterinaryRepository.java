package com.programadorescl.petconsultation.domain.repository;

import com.programadorescl.petconsultation.domain.model.entity.Veterinary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryRepository extends MongoRepository<Veterinary, String> {
    Veterinary findByName(String name);

    Veterinary findByProfessionalLicense(String license);
}
