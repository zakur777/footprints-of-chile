package com.programadorescl.medicalconsultation.domain.gateways;


import com.programadorescl.medicalconsultation.domain.entities.Pet;

import java.util.List;
import java.util.Optional;

public interface PetGateway {
    Optional<Pet> findById(int id);

    List<Pet> getAll();

    Pet update(Pet pet);

    Pet save(Pet pet);

    void delete(Pet pet);
}
