package com.programadorescl.petconsultation.domain.valueobject;

import com.programadorescl.petconsultation.domain.model.entity.Veterinary;

import org.springframework.hateoas.RepresentationModel;


public class PetConsultationVO extends RepresentationModel<PetConsultationVO> {
    private String id;
    private String name;
    private String nationalRegistry;
    private boolean isCertificate;
    private Veterinary veterinary;

    public PetConsultationVO() {

    }

    public PetConsultationVO(String id, String name, String nationalRegistry, Boolean isCertificate, Veterinary veterinary) {
        this.id = id;
        this.name = name;
        this.nationalRegistry = nationalRegistry;
        this.isCertificate = isCertificate;
        this.veterinary = veterinary;
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
