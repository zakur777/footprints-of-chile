package com.programadorescl.userpetservice.application.services.user;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.ports.in.user.GetPetsInfoUseCase;
import com.programadorescl.userpetservice.application.ports.out.user.UserGateway;
import com.programadorescl.userpetservice.application.services.exceptions.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPetsInfoService implements GetPetsInfoUseCase {

    @Autowired
    private UserGateway gateway;

    @Override
    public List<Pet> execute(Long userId) throws Exception {
        if (gateway.getUserById(userId).isPresent()) {
            return gateway.getPetsInfo(userId);
        }
        Object[] args = {userId};
        throw new UserNotFoundException("userNotFound", args);
    }
}
