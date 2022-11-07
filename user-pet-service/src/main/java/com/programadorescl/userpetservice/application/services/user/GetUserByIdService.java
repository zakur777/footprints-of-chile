package com.programadorescl.userpetservice.application.services.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.application.ports.in.user.GetUserByIdUseCase;
import com.programadorescl.userpetservice.application.ports.out.user.UserGateway;
import com.programadorescl.userpetservice.application.services.exceptions.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByIdService implements GetUserByIdUseCase {

    @Autowired
    private UserGateway gateway;

    @Override
    public Optional<User> execute(Long id) throws Exception {
        Optional<User> userById = gateway.getUserById(id);
        if (userById.isPresent()) {
            return userById;
        }
        Object[] args = {id};
        throw new UserNotFoundException("userNotFound", args);
    }
}
