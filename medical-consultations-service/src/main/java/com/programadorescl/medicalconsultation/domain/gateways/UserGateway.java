package com.programadorescl.medicalconsultation.domain.gateways;

import com.programadorescl.medicalconsultation.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    Optional<User> findById(Long id);

    List<User> getAll();

    User save(User user);

    User update(User user);

    void delete(User user);
}
