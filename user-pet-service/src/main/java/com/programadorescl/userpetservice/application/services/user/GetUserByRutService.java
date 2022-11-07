package com.programadorescl.userpetservice.application.services.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.application.ports.in.user.GetUserByRutUseCase;
import com.programadorescl.userpetservice.application.ports.out.user.UserGateway;
import com.programadorescl.userpetservice.application.services.exceptions.user.DuplicateUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserByRutService implements GetUserByRutUseCase {

    @Autowired
    private UserGateway gateway;

    @Override
    public User execute(String rut) throws Exception {
        return gateway.getUserByRut(rut);
    }
}
