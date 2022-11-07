package com.programadorescl.userpetservice.application.ports.in.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.commons.UseCase;

import java.util.Optional;

public interface GePetByIdUseCase extends UseCase<String, Optional<Pet>> {
}
