package com.programadorescl.userpetservice.application.ports.out.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import java.util.List;
import java.util.Optional;

public interface PetGateway {

    List<Pet> getAll();

    Optional<Pet> getPetById(String name);

    Pet savePet(Pet pet);

    Boolean deletePet(String name);

    Pet update(Pet pet);

    List<Pet> findByBreedOrName(String param);
}
