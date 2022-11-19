package com.programadorescl.userpetservice.infrastructure.adapters.out.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.ports.out.pet.PetGateway;
import com.programadorescl.userpetservice.infrastructure.crud.pet.PetCrudRepository;
import com.programadorescl.userpetservice.infrastructure.mappers.pet.PetMapper;
import com.programadorescl.userpetservice.infrastructure.models.pet.PetDAO;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Transactional
@Repository
public class PetRepository implements PetGateway {

    private final PetCrudRepository crudRepository;

    private final PetMapper mapper;

    @Override
    public List<Pet> getAll() {
        List<PetDAO> petDaos = (List<PetDAO>) crudRepository.findAll();
        return mapper.toDomainModels(petDaos);
    }

    @Override
    public Optional<Pet> getPetById(String name) {
        return crudRepository.findById(name).map(pet -> mapper.toDomainModel(pet));
    }

    @Override
    public Pet savePet(Pet pet) {
        PetDAO petDAO = mapper.toEntity(pet);
        return mapper.toDomainModel(crudRepository.save(petDAO));
    }

    @Override
    public Boolean deletePet(String name) {
        if (this.getPetById(name).isPresent()) {
            crudRepository.deleteById(name);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Pet update(Pet pet) {
        PetDAO petDAO = mapper.toEntity(pet);
        return mapper.toDomainModel(crudRepository.save(petDAO));
    }

    @Override
    public List<Pet> findByBreedOrName(String param) {
        return mapper.toDomainModels(crudRepository.findByBreedOrName(param));
    }
}
