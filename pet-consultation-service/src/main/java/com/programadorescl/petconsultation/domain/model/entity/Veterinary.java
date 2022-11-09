package com.programadorescl.petconsultation.domain.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.Links;

import java.util.List;

@Document("veterinarians")
public class Veterinary extends BaseEntity<String> {

    @Indexed(unique = true)
    private String professionalLicense;

    private String lastName;

    public Veterinary() {
        super(null, null);
    }

    public Veterinary(String id, String name, String professionalLicense, String lastName) {
        super(id, name);
        this.professionalLicense = professionalLicense;
        this.lastName = lastName;
    }

    public Veterinary(String id, String name) {
        super(id, name);
    }

    public static Veterinary getDummyVeterinary() {
        return new Veterinary(null, null);
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
