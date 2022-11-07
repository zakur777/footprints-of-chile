package com.programadorescl.petconsultation.domain.repository;

import com.programadorescl.petconsultation.domain.model.entity.Veterinary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VeterinaryRepository extends MongoRepository<Veterinary, String> {

}
