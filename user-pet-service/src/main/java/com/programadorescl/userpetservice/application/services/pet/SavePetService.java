package com.programadorescl.userpetservice.application.services.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.ports.in.pet.SavePetUseCase;
import com.programadorescl.userpetservice.application.ports.out.pet.PetGateway;
import com.programadorescl.userpetservice.application.services.exceptions.pet.DuplicatePetException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePetService implements SavePetUseCase {

    @Autowired private PetGateway gateway;

    @Override
    public Pet execute(Pet pet) throws Exception {
        Optional<Pet> petById = gateway.getPetById(pet.getName());
        if (!petById.isPresent()) {
            gateway.savePet(pet);
        }
        Object[] args = {pet.getName()};
        throw new DuplicatePetException("duplicatePet", args);
    }
}
