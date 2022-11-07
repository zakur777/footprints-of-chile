package com.programadorescl.medicalconsultation.domain.entities;

public class Pet {

    private String name;
    private boolean activeTreatment;
    private String breed;
    private Long userId;
    private String status;

    public Pet() {

    }

    public Pet(String name, boolean activeTreatment, String breed, Long userId, String status) {
        this.name = name;
        this.activeTreatment = activeTreatment;
        this.breed = breed;
        this.userId = userId;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActiveTreatment() {
        return activeTreatment;
    }

    public void setActiveTreatment(boolean activeTreatment) {
        this.activeTreatment = activeTreatment;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
