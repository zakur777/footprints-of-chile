package com.programadorescl.userpetservice.infrastructure.crud.user;

import com.programadorescl.userpetservice.infrastructure.models.user.UserDAO;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<UserDAO, Long> {

    @Query("select u from UserDAO u where u.status='1'")
    List<UserDAO> findAllActives();

    UserDAO findByRutEquals(String rut);
}
