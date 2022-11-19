package com.programadorescl.medicalconsultation.persistence.mappers;

import com.programadorescl.medicalconsultation.domain.entities.MedicalConsultation;
import com.programadorescl.medicalconsultation.persistence.models.MedicalConsultationDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalConsultationMapper
        extends GenericMapper<MedicalConsultationDAO, MedicalConsultation> {}
