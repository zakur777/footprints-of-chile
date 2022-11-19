package com.programadorescl.medicalconsultation.persistence.mappers;

import com.programadorescl.medicalconsultation.domain.entities.PetConsultation;
import com.programadorescl.medicalconsultation.persistence.dto.RequestPetConsultationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetConsultationMapper
        extends GenericMapper<RequestPetConsultationDTO, PetConsultation> {}
