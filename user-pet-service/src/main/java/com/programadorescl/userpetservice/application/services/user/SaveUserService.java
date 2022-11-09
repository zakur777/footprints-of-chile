package com.programadorescl.userpetservice.application.services.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.application.ports.in.user.SaveUserUseCase;
import com.programadorescl.userpetservice.application.ports.out.user.UserGateway;
import com.programadorescl.userpetservice.application.services.exceptions.user.DuplicateUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class SaveUserService implements SaveUserUseCase {

    @Autowired
    private UserGateway gateway;

    @Override
    public User execute(User user) throws Exception {
        User userByRut = gateway.getUserByRut(user.getRut());
        if (isNull(userByRut)) {
            return gateway.saveUser(user);
        }
        Object[] args = {user.getRut()};
        throw new DuplicateUserException("duplicateUser", args);

    }
}
