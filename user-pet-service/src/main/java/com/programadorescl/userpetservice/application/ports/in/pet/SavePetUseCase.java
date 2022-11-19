package com.programadorescl.userpetservice.application.ports.in.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.commons.UseCase;

public interface SavePetUseCase extends UseCase<Pet, Pet> {}
