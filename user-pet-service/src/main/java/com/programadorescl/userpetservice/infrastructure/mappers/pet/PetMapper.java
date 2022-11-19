package com.programadorescl.userpetservice.infrastructure.mappers.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.infrastructure.mappers.GenericMapper;
import com.programadorescl.userpetservice.infrastructure.models.pet.PetDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper extends GenericMapper<PetDAO, Pet> {}
