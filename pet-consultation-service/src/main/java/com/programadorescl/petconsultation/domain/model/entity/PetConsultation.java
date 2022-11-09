package com.programadorescl.petconsultation.domain.model.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

@Document("pet_consultation")
public class PetConsultation extends BaseEntity<String> {

    @Indexed(unique = true)
    private String nationalRegistry;
    private boolean isCertificate;

    @DBRef
    private Veterinary veterinary;

    public PetConsultation() {
        super(null, null);
    }

    public PetConsultation(String id, String name, String nationalRegistry, Veterinary veterinary) {
        super(id, name);
        this.nationalRegistry = nationalRegistry;
        this.isCertificate = true;
        this.veterinary = veterinary;
    }

    public PetConsultation(String id, String name) {
        super(id, name);
    }

    public static PetConsultation getDummyPetConsultation() {
        return new PetConsultation(null, null);
    }

    public String getNationalRegistry() {
        return nationalRegistry;
    }

    public void setNationalRegistry(String nationalRegistry) {
        this.nationalRegistry = nationalRegistry;
    }

    public boolean isIsCertificate() {
        return isCertificate;
    }

    public void setCertificate(boolean certificate) {
        isCertificate = certificate;
    }

    public Veterinary getVeterinary() {
        return veterinary;
    }

    public void setVeterinary(Veterinary veterinary) {
        this.veterinary = veterinary;
    }


    @Override
    public String toString() {
        return String.format(
                "{id: %s, name: %s, nationalRegistry: %s, isCertificate: %s"
                        + ", veterinary: %s}",
                id, name, nationalRegistry, isCertificate,
                veterinary);
    }
}
