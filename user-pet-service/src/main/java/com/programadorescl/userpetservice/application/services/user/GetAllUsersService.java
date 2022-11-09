package com.programadorescl.userpetservice.application.services.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.application.ports.in.user.GetAllUsersUseCase;
import com.programadorescl.userpetservice.application.ports.out.user.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersService implements GetAllUsersUseCase {

    @Autowired
    private UserGateway gateway;

    @Override
    public List<User> execute(Void unused) throws Exception {
        return gateway.getAll();
    }
}
