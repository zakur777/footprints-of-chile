package com.programadorescl.userpetservice.application.ports.out.user;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.domains.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserGateway {

    List<User> getAll();

    Optional<User> getUserById(Long id);

    User saveUser(User user);

    Boolean deleteUser(Long id);

    User updateUser(User user);

    List<Pet> getPetsInfo(Long userId);

    User getUserByRut(String rut);
}
