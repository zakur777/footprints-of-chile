package com.programadorescl.userpetservice.application.services.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.ports.in.pet.DeletePetByIdUseCase;
import com.programadorescl.userpetservice.application.ports.out.pet.PetGateway;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetNotFoundException;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetWithTreatmentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePetByIdService implements DeletePetByIdUseCase {

    @Autowired
    private PetGateway gateway;

    @Override
    public Boolean execute(String name) throws Exception {
        Optional<Pet> petById = gateway.getPetById(name);
        if (petById.isPresent()) {
            Pet pet = petById.get();
            if (!pet.isActiveTreatment()) {
                pet.setStatus("0");
                gateway.savePet(pet);
                return true;
            }
            Object[] args = {pet.getName()};
            throw new PetWithTreatmentException("petWithTreatment", args);
        }
        Object[] args = {name};
        throw new PetNotFoundException("petNotFound", args);
    }
}
