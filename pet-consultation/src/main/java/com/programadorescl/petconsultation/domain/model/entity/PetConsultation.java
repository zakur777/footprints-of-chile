package com.programadorescl.petconsultation.domain.model.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pet_consultation")
public class PetConsultation extends BaseEntity<String> {

    @Indexed(unique = true)
    private String nationalRegistry;
    private Boolean isCertificate;
    private Veterinary veterinary;

    public PetConsultation(String id, String name, String nationalRegistry, Boolean isCertificate, Veterinary veterinary) {
        super(id, name);
        this.nationalRegistry = nationalRegistry;
        this.isCertificate = isCertificate;
        this.veterinary = veterinary;
    }

    public PetConsultation(String id, String name) {
        super(id, name);
    }

    public String getNationalRegistry() {
        return nationalRegistry;
    }

    public void setNationalRegistry(String nationalRegistry) {
        this.nationalRegistry = nationalRegistry;
    }

    public Boolean getCertificate() {
        return isCertificate;
    }

    public void setCertificate(Boolean certificate) {
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
