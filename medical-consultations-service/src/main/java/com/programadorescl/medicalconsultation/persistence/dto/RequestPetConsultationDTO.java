package com.programadorescl.medicalconsultation.persistence.dto;

import lombok.Data;

@Data
public class RequestPetConsultationDTO {
    private String id;
    private String name;
    private String nationalRegistry;
    private boolean isCertificate;
    private RequestVeterinaryDTO veterinary;
}
