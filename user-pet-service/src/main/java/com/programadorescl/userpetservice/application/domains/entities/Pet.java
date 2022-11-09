package com.programadorescl.userpetservice.application.domains.entities;

import org.springframework.hateoas.RepresentationModel;

public class Pet extends RepresentationModel<Pet> {

    private String name;
    private boolean activeTreatment;
    private String breed;

    private Long userId;

    private String status;


    public Pet() {
    }

    public Pet(String name, String breed, String status) {
        this.name = name;
        this.breed = breed;
        this.activeTreatment = false;
        this.status = "1";
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

    @Override
    public String toString() {
        return "Pet{" + name + '\'' +
                '}';
    }
}
