package com.programadorescl.userpetservice.infrastructure.mappers.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.infrastructure.mappers.GenericMapper;
import com.programadorescl.userpetservice.infrastructure.models.user.UserDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDAO, User> {}
