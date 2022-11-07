package com.programadorescl.userpetservice.application.ports.in.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.commons.UseCase;

import java.util.Optional;

public interface GetUserByIdUseCase  extends UseCase<Long, Optional<User>> {
}
