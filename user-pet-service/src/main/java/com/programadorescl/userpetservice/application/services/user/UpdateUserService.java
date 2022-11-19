package com.programadorescl.userpetservice.application.services.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.application.ports.in.user.UpdateUserUseCase;
import com.programadorescl.userpetservice.application.ports.out.user.UserGateway;
import com.programadorescl.userpetservice.application.services.exceptions.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService implements UpdateUserUseCase {

    @Autowired private UserGateway gateway;

    @Override
    public User execute(User user) throws Exception {
        if (gateway.getUserById(user.getUserId()).isPresent()) {
            return gateway.updateUser(user);
        }
        Object[] args = {user.getUserId()};
        throw new UserNotFoundException("userNotFound", args);
    }
}
