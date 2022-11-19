package com.programadorescl.userpetservice.application.ports.in.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.commons.UseCase;
import java.util.List;

public interface GetAllPetsUseCase extends UseCase<Void, List<Pet>> {}
