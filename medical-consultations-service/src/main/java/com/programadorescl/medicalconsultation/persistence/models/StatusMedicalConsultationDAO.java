package com.programadorescl.medicalconsultation.persistence.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusMedicalConsultationDAO {
    OPEN,
    UNDER_TREATMENT,
    CLOSED
}
