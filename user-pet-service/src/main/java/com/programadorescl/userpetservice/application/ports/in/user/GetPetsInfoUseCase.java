package com.programadorescl.userpetservice.application.ports.in.user;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.commons.UseCase;
import java.util.List;

public interface GetPetsInfoUseCase extends UseCase<Long, List<Pet>> {}
