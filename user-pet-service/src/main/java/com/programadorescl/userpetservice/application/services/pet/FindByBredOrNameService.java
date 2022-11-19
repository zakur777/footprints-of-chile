package com.programadorescl.userpetservice.application.services.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.ports.in.pet.FindByBreedOrNameUseCase;
import com.programadorescl.userpetservice.application.ports.out.pet.PetGateway;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindByBredOrNameService implements FindByBreedOrNameUseCase {

    @Autowired private PetGateway gateway;

    @Override
    public List<Pet> execute(String param) throws Exception {
        List<Pet> petByBreedOrName = gateway.findByBreedOrName(param);
        if (!petByBreedOrName.isEmpty()) {
            return petByBreedOrName;
        }
        Object[] args = {param};
        throw new PetNotFoundException("petNotFound", args);
    }
}
