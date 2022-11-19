package com.programadorescl.userpetservice.application.ports.in.user;

import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.commons.UseCase;
import java.util.List;

public interface GetAllUsersUseCase extends UseCase<Void, List<User>> {}
