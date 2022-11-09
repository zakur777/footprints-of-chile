package com.programadorescl.userpetservice.application.services.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.ports.in.pet.UpdatePetUseCase;
import com.programadorescl.userpetservice.application.ports.out.pet.PetGateway;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetNotFoundException;
import com.programadorescl.userpetservice.application.services.exceptions.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePetService implements UpdatePetUseCase {

    @Autowired
    private PetGateway gateway;

    @Override
    public Pet execute(Pet pet) throws Exception {
        if (gateway.getPetById(pet.getName()).isPresent()) {
            return gateway.update(pet);
        }
        Object[] args = {pet.getName()};
        throw new PetNotFoundException("petNotFound", args);
    }
}
