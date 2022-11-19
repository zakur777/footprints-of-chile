package com.programadorescl.userpetservice.application.services.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.ports.in.pet.GetAllPetsUseCase;
import com.programadorescl.userpetservice.application.ports.out.pet.PetGateway;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllPetsService implements GetAllPetsUseCase {

    @Autowired private PetGateway gateway;

    @Override
    public List<Pet> execute(Void unused) throws Exception {
        return gateway.getAll();
    }
}
