package com.programadorescl.medicalconsultation.domain.entities;

public class PetConsultation {
    private String id;
    private String name;
    private String nationalRegistry;
    private boolean isCertificate;
    // private Veterinary veterinary;

    public PetConsultation() {}

    public PetConsultation(String id, String name, String nationalRegistry, boolean isCertificate) {
        this.id = id;
        this.name = name;
        this.nationalRegistry = nationalRegistry;
        this.isCertificate = isCertificate;
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

    public String getNationalRegistry() {
        return nationalRegistry;
    }

    public void setNationalRegistry(String nationalRegistry) {
        this.nationalRegistry = nationalRegistry;
    }

    public boolean isCertificate() {
        return isCertificate;
    }

    public void setCertificate(boolean certificate) {
        isCertificate = certificate;
    }
}
