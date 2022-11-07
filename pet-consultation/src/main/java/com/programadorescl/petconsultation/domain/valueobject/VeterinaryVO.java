package com.programadorescl.petconsultation.domain.valueobject;

public class VeterinaryVO {

    private String id;
    private String name;
    private String professionalLicense;
    private String lastName;

    public VeterinaryVO() {

    }

    public VeterinaryVO(String id, String name, String professionalLicense, String lastName) {
        this.id = id;
        this.name = name;
        this.professionalLicense = professionalLicense;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format(
                "{id: %s, name: %s, professionalLicense: %s, lastName: %s",
                id, name, professionalLicense, lastName);
    }
}
