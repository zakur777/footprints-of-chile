package com.programadorescl.medicalconsultation.domain.services;

import com.programadorescl.medicalconsultation.domain.entities.User;
import com.programadorescl.medicalconsultation.domain.gateways.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserGateway gateway;

    public List<User> getAll() {
        return gateway.getAll();
    }

    public Optional<User> findById(Long id) {
        return gateway.findById(id);
    }

    public User save(User user) {
        return gateway.save(user);
    }

    public User update(Long id, User user) {
        Optional<User> userOptional = gateway.findById(id);

        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dueño no existe");
        }

        user.setUserId(id);
        user.setName(user.getName());

        return gateway.update(user);
    }

    public void deleteUser(Long id) {
        gateway.findById(id).map(dueno -> {
            gateway.delete(dueno);
            return true;
        });
    }
}
