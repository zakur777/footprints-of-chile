package com.programadorescl.medicalconsultation.domain.entities;

public class Veterinary {
    private String Id;
    private String name;
    private String professionalLicense;
    private String lastName;

    public Veterinary() {

    }
    public Veterinary(String id, String name, String professionalLicense, String lastName) {
        Id = id;
        this.name = name;
        this.professionalLicense = professionalLicense;
        this.lastName = lastName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
