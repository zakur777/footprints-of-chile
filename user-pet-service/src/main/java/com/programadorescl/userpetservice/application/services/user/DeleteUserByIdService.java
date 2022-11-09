package com.programadorescl.userpetservice.application.services.user;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.application.ports.in.user.DeleteUserByIdUseCase;
import com.programadorescl.userpetservice.application.ports.out.user.UserGateway;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetWithTreatmentException;
import com.programadorescl.userpetservice.application.services.exceptions.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeleteUserByIdService implements DeleteUserByIdUseCase {

    @Autowired
    private UserGateway gateway;




    @Override
    public Boolean execute(Long id) throws Exception {
        Optional<User> optionalUserById = gateway.getUserById(id);
        if (optionalUserById.isPresent()) {
            List<Pet> pets = optionalUserById.get().getPets().stream()
                    .filter(pet -> pet.isActiveTreatment())
                    .collect(Collectors.toList());
            if (pets.isEmpty()) {
                User user = optionalUserById.get();
                user.setStatus("0");
                gateway.saveUser(user);
                return true;
            }
            Object[] args = pets.toArray();
            throw new PetWithTreatmentException("petWithTreatment", args);
        }
        Object[] args = {id};
        throw new UserNotFoundException("userNotFound", args);
    }
}
