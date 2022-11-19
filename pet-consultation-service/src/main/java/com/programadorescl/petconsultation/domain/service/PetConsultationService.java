package com.programadorescl.petconsultation.domain.service;

import com.programadorescl.petconsultation.domain.model.entity.PetConsultation;
import java.util.List;

public interface PetConsultationService {

    public PetConsultation add(PetConsultation petConsultation) throws Exception;

    public PetConsultation update(PetConsultation petConsultation) throws Exception;

    public void delete(String id) throws Exception;

    public PetConsultation findById(String id) throws Exception;

    public PetConsultation findByNationalRegistry(String license) throws Exception;

    public List<PetConsultation> findALL() throws Exception;
}
