package com.programadorescl.petconsultation.domain.service;

import com.programadorescl.petconsultation.common.DuplicateVeterinaryException;
import com.programadorescl.petconsultation.common.VeterinaryNotFoundException;
import com.programadorescl.petconsultation.domain.model.entity.Entity;
import com.programadorescl.petconsultation.domain.model.entity.Veterinary;
import com.programadorescl.petconsultation.domain.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class VeterinaryServiceImpl implements VeterinaryService {

    @Autowired
    private VeterinaryRepository repository;


    @Override
    public Veterinary add(Veterinary veterinary) throws Exception {
        Veterinary byProfessionalLicense = repository.findByProfessionalLicense(veterinary.getProfessionalLicense());
        if (isNull(byProfessionalLicense)) {
            Object[] args = {veterinary.getName()};
            throw new DuplicateVeterinaryException("duplicateVeterinary", args);
        }

        return repository.save(veterinary);
    }

    @Override
    public Veterinary update(Veterinary veterinary) throws Exception {
        return repository.save(veterinary);
    }

    @Override
    public void delete(String license) throws Exception {
        Veterinary veterinary = repository.findByProfessionalLicense(license);
        if (isNull(veterinary)) {
            Object[] args = {veterinary.getName(), veterinary.getProfessionalLicense()};
            throw new VeterinaryNotFoundException("veterinaryNotFound", args);
        }
        repository.save(veterinary);
    }

    @Override
    public Veterinary findById(String id) throws Exception {
        Optional<Veterinary> veterinaryById = repository.findById(id);
        if (veterinaryById.isPresent()) {
            return veterinaryById.get();
        }
        Object[] args = {veterinaryById.get().getName(), veterinaryById.get().getProfessionalLicense(),
                veterinaryById.get().getId()};
        throw new VeterinaryNotFoundException("veterinaryNotFound", args);
    }

    @Override
    public Veterinary findByProfessionalLicense(String license) throws Exception {
        Veterinary veterinary = repository.findByProfessionalLicense(license);
        if (isNull(veterinary)) {
            Object[] args = {veterinary.getName(), veterinary.getProfessionalLicense()};
            throw new VeterinaryNotFoundException("veterinaryNotFound", args);
        }
        return veterinary;
    }


}
