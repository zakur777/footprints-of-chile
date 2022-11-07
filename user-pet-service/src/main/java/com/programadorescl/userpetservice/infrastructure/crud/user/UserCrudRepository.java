package com.programadorescl.userpetservice.infrastructure.crud.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.infrastructure.models.user.UserDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<UserDAO, Long> {

    @Query("select u from UserDAO u where u.status='1'")
    List<UserDAO> findAllActives();
    UserDAO findByRutEquals(String rut);
}
