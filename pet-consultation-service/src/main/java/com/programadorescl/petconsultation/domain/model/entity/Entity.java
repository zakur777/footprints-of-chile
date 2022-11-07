package com.programadorescl.petconsultation.domain.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.RepresentationModel;

public abstract class Entity<T> extends RepresentationModel<PetConsultation> {

    @Id
    T id;
    String name;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
