package com.programadorescl.medicalconsultation.persistence.mappers;

import com.programadorescl.medicalconsultation.domain.entities.User;
import com.programadorescl.medicalconsultation.persistence.dto.RequestUserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<RequestUserDTO, User> {
}
