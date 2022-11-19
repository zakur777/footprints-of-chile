package com.programadorescl.medicalconsultation.persistence.mappers;

import com.programadorescl.medicalconsultation.domain.entities.Pet;
import com.programadorescl.medicalconsultation.persistence.dto.RequestPetDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper extends GenericMapper<RequestPetDTO, Pet> {}
