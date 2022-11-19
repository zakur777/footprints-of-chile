package com.programadorescl.medicalconsultation.domain.entities;

import java.util.List;

public class User {
    private Long userId;
    private String rut;
    private String name;
    private String address;
    private String city;
    private String phone;
    private List<Pet> pets;

    public User() {}

    public User(
            Long userId,
            String rut,
            String name,
            String address,
            String city,
            String phone,
            List<Pet> pets) {
        this.userId = userId;
        this.rut = rut;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.pets = pets;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
