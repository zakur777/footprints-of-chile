package com.programadorescl.petconsultation.domain.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("veterinarians")
public class Veterinary extends BaseEntity<String> {

    private String professionalLicense;
    private String lastName;

    public Veterinary(String id, String name, String professionalLicense, String lastName) {
        super(id, name);
        this.professionalLicense = professionalLicense;
        this.lastName = lastName;
    }

    public Veterinary(String id, String name) {
        super(id, name);
    }

    public String getProfessionalLicense() {
        return professionalLicense;
    }

    public void setProfessionalLicense(String professionalLicense) {
        this.professionalLicense = professionalLicense;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "{id: %s, name: %s, professionalLicense: %s, lastName: %s",
                id, name, professionalLicense, lastName);
    }
}

