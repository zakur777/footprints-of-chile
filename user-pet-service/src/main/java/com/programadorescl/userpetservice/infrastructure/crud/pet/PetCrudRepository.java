package com.programadorescl.userpetservice.infrastructure.crud.pet;

import com.programadorescl.userpetservice.infrastructure.models.pet.PetDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetCrudRepository extends CrudRepository<PetDAO, String> {

    @Query("select p from PetDAO p where p.breed = :breedOrName OR p.name = :breedOrName")
    List<PetDAO> findByBreedOrName(@Param("breedOrName") String param);
}
