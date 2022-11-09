package com.programadorescl.medicalconsultation.persistence.dto;

import lombok.Data;

@Data
public class RequestPetDTO {

    private String name;
    private boolean activeTreatment;
    private String breed;
    private Long userId;
    private String status;


}
