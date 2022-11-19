package com.programadorescl.userpetservice.application.ports.in.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.commons.UseCase;

public interface GetUserByRutUseCase extends UseCase<String, User> {}
