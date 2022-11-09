package com.programadorescl.userpetservice.infrastructure.mappers.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.infrastructure.mappers.GenericMapper;
import com.programadorescl.userpetservice.infrastructure.models.user.UserDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDAO, User> {

}
