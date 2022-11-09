package com.programadorescl.petconsultation.domain.service;

import com.programadorescl.petconsultation.common.DuplicateVeterinaryException;
import com.programadorescl.petconsultation.common.VeterinaryNotFoundException;
import com.programadorescl.petconsultation.domain.model.entity.Entity;
import com.programadorescl.petconsultation.domain.model.entity.Veterinary;
import com.programadorescl.petconsultation.domain.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
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
            return repository.save(veterinary);
        }
        Object[] args = {veterinary.getProfessionalLicense()};
        throw new DuplicateVeterinaryException("duplicateVeterinary", args);


    }

    @Override
    public Veterinary update(Veterinary veterinary) throws Exception {
        Optional<Veterinary> optionalVeterinary = repository.findById(veterinary.getId());
        if (optionalVeterinary.isEmpty()) {
            Object[] args = {veterinary.getName(), veterinary.getProfessionalLicense(),
                    veterinary.getId()};
            throw new VeterinaryNotFoundException("veterinaryNotFound", args);
        }
        return repository.save(veterinary);
    }

    @Override
    public void delete(String license) throws Exception {
        Veterinary veterinary = repository.findByProfessionalLicense(license);
        if (isNull(veterinary)) {
            Object[] args = {"NO-Name", license,
                    "NO-ID"};
            throw new VeterinaryNotFoundException("veterinaryNotFound", args);
        }
        repository.delete(veterinary);
    }

    @Override
    public Veterinary findById(String id) throws Exception {
        Optional<Veterinary> veterinaryById = repository.findById(id);
        if (veterinaryById.isEmpty()) {
            Object[] args = {"No-Name", "No-Professional-License",
                    id};
            throw new VeterinaryNotFoundException("veterinaryNotFound", args);
        }
        return veterinaryById.get();
    }

    @Override
    public Veterinary findByProfessionalLicense(String license) throws Exception {
        Veterinary veterinary = repository.findByProfessionalLicense(license);
        if (isNull(veterinary)) {
            Object[] args = {"No-Name", license, "No-ID"};
            throw new VeterinaryNotFoundException("veterinaryNotFound", args);
        }
        return veterinary;
    }

    @Override
    public List<Veterinary> findALL() throws Exception {
        return repository.findAll();
    }


}
