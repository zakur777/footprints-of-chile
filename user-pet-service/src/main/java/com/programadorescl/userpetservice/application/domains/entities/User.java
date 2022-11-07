package com.programadorescl.userpetservice.application.domains.entities;

import com.programadorescl.userpetservice.application.domains.valueobjects.user.Rut;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public class User extends RepresentationModel<User> {

    private Long userId;
    private String rut;
    private String name;
    private String address;
    private String city;
    private String phone;
    private List<Pet> pets;
    private String status;

    public User() {
    }

    public User(String rut, Long userId, String name, String address, String city, String phone, List<Pet> pets) {
        this.rut = rut;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.pets = pets;
        this.status = "1";
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", rut='" + rut + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
