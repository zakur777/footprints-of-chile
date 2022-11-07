package com.programadorescl.medicalconsultation.domain.services;

import com.programadorescl.medicalconsultation.domain.entities.Pet;
import com.programadorescl.medicalconsultation.domain.gateways.PetGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetGateway gateway;

    public List<Pet> getAll() {
        return gateway.getAll();
    }

    public Optional<Pet> findById(int id) {
        return gateway.findById(id);
    }

    public Pet save(Pet pet) {
        return gateway.save(pet);
    }

    /*
    public Pet update(int id, RequestPetDTO dto) {
        Pet mascota = new Pet();

        Optional<Pet> mascota1 = gateway.findById(id);

        if(mascota1.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pet no existe");
        }

        mascota.getName(id);

        return gateway.update(mascota);
    }
    */
    public Pet update(Pet pet) {
        return gateway.update(pet);
    }

    public void deletePet(int id) {
        gateway.findById(id).map(mascota -> {
            gateway.delete(mascota);
            return true;
        });
    }
}
