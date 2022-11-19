package com.programadorescl.userpetservice.application.services.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.ports.in.pet.GePetByIdUseCase;
import com.programadorescl.userpetservice.application.ports.out.pet.PetGateway;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetPetByIdService implements GePetByIdUseCase {

    @Autowired private PetGateway gateway;

    @Override
    public Optional<Pet> execute(String name) throws Exception {
        Optional<Pet> petById = gateway.getPetById(name);
        if (petById.isPresent()) {
            return petById;
        }
        Object[] args = {name};
        throw new PetNotFoundException("petNotFound", args);
    }
}
