package com.programadorescl.petconsultation.domain.service;

import com.programadorescl.petconsultation.common.DuplicatePetConsultationException;
import com.programadorescl.petconsultation.common.PetConsultationNotFoundException;
import com.programadorescl.petconsultation.common.VeterinaryNotFoundException;
import com.programadorescl.petconsultation.domain.model.entity.PetConsultation;
import com.programadorescl.petconsultation.domain.model.entity.Veterinary;
import com.programadorescl.petconsultation.domain.repository.PetConsultationRepository;
import com.programadorescl.petconsultation.domain.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class PetConsultationServiceImpl implements PetConsultationService {

    @Autowired
    private PetConsultationRepository repository;

    @Autowired
    private VeterinaryRepository veterinaryRepository;


    @Override
    public PetConsultation add(PetConsultation petConsultation) throws Exception {
        PetConsultation byNationalRegistry = repository.findByNationalRegistry(petConsultation.getNationalRegistry());
        Optional<Veterinary> veterinarybyId = veterinaryRepository.findById(petConsultation.getVeterinary().getId());

        if (veterinarybyId.isEmpty()) {
            Object[] args = {petConsultation.getNationalRegistry()};
            throw new VeterinaryNotFoundException("veterinaryNotFound", args);
        }
        petConsultation.setVeterinary(veterinarybyId.get());
        if (isNull(byNationalRegistry)) {
            return repository.save(petConsultation);
        }
        Object[] args = {petConsultation.getNationalRegistry()};
        throw new DuplicatePetConsultationException("duplicatePetConsultation", args);


    }

    @Override
    public PetConsultation update(PetConsultation petConsultation) throws Exception {
        Optional<PetConsultation> optionalPetConsultation = repository.findById(petConsultation.getId());
        Optional<Veterinary> veterinarybyId = veterinaryRepository.findById(petConsultation.getVeterinary().getId());


        if (veterinarybyId.isEmpty()) {
            Object[] args = {petConsultation.getNationalRegistry()};
            throw new VeterinaryNotFoundException("veterinaryNotFound", args);
        }
        petConsultation.setVeterinary(veterinarybyId.get());
        if (optionalPetConsultation.isEmpty()) {
            Object[] args = {petConsultation.getName(), petConsultation.getNationalRegistry(),
                    petConsultation.getId()};
            throw new PetConsultationNotFoundException("petConsultationNotFound", args);
        }
        return repository.save(petConsultation);
    }

    @Override
    public void delete(String nationalRegistry) throws Exception {
        PetConsultation petConsultation = repository.findByNationalRegistry(nationalRegistry);
        if (isNull(petConsultation)) {
            Object[] args = {"NO-Name", nationalRegistry,
                    "NO-ID"};
            throw new PetConsultationNotFoundException("petConsultationNotFound", args);
        }
        repository.delete(petConsultation);
    }

    @Override
    public PetConsultation findById(String id) throws Exception {
        Optional<PetConsultation> petConsultationById = repository.findById(id);
        if (petConsultationById.isEmpty()) {
            Object[] args = {"No-Name", "No-National-Registry",
                    id};
            throw new PetConsultationNotFoundException("petConsultationNotFound", args);
        }
        return petConsultationById.get();
    }

    @Override
    public PetConsultation findByNationalRegistry(String nationalRegistry) throws Exception {
        PetConsultation petConsultation = repository.findByNationalRegistry(nationalRegistry);
        if (isNull(petConsultation)) {
            Object[] args = {"No-Name", nationalRegistry, "No-ID"};
            throw new PetConsultationNotFoundException("petConsultationNotFound", args);
        }
        return petConsultation;
    }

    @Override
    public List<PetConsultation> findALL() throws Exception {
        return repository.findAll();
    }

}
