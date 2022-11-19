package com.programadorescl.petconsultation.domain.service;

import com.programadorescl.petconsultation.domain.model.entity.Veterinary;
import java.util.List;

public interface VeterinaryService {

    public Veterinary add(Veterinary veterinary) throws Exception;

    public Veterinary update(Veterinary veterinary) throws Exception;

    public void delete(String id) throws Exception;

    public Veterinary findById(String id) throws Exception;

    public Veterinary findByProfessionalLicense(String license) throws Exception;

    public List<Veterinary> findALL() throws Exception;

    // TODO findALL

}
