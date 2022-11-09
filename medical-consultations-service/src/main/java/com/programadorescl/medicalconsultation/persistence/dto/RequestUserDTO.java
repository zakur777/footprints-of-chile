package com.programadorescl.medicalconsultation.persistence.dto;

import lombok.Data;

import java.util.List;

@Data
public class RequestUserDTO {
    private Long userId;
    private String rut;
    private String name;
    private String address;
    private String city;
    private String phone;
    private List<RequestPetDTO> pets;
    private String status;
}
