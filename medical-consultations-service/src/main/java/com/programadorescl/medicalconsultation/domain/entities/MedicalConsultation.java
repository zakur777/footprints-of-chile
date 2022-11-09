package com.programadorescl.medicalconsultation.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.programadorescl.medicalconsultation.persistence.models.MedicalConsultationDAO;
import org.springframework.hateoas.RepresentationModel;

public class MedicalConsultation extends RepresentationModel<MedicalConsultation> {
    private Long id;
    private Long userId;
    private String petName;
    private String idPetConsultation;
    private User user;
    private PetConsultation petConsultation;
    private Pet pet;

    private PaymentMethod paymentMethod;
    private String processDescription;
    private StatusMedicalConsultation statusMedicalConsultation;
    private boolean isTreatment;
    private Long totalAmount;

    private Long payment;

    public MedicalConsultation() {

    }

    public MedicalConsultation(Long id, Long userId,
                               String petName,
                               String idPetConsultation,
                               User user,
                               PetConsultation petConsultation,
                               Pet pet,
                               PaymentMethod paymentMethod,
                               String processDescription,
                               StatusMedicalConsultation statusMedicalConsultation,
                               boolean isTreatment,
                               Long totalAmount,
                               Long payment) {
        this.id = id;
        this.userId = userId;
        this.petName = petName;
        this.idPetConsultation = idPetConsultation;
        this.user = user;
        this.petConsultation = petConsultation;
        this.pet = pet;
        this.paymentMethod = paymentMethod;
        this.processDescription = processDescription;
        this.statusMedicalConsultation = statusMedicalConsultation;
        this.isTreatment = isTreatment;
        this.totalAmount = totalAmount;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getIdPetConsultation() {
        return idPetConsultation;
    }

    public void setIdPetConsultation(String idPetConsultation) {
        this.idPetConsultation = idPetConsultation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PetConsultation getPetConsultation() {
        return petConsultation;
    }

    public void setPetConsultation(PetConsultation petConsultation) {
        this.petConsultation = petConsultation;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProcessDescription() {
        return processDescription;
    }

    public void setProcessDescription(String processDescription) {
        this.processDescription = processDescription;
    }

    public StatusMedicalConsultation getStatusMedicalConsultation() {
        return statusMedicalConsultation;
    }

    public void setStatusMedicalConsultation(StatusMedicalConsultation statusMedicalConsultation) {
        this.statusMedicalConsultation = statusMedicalConsultation;
    }

    public boolean isTreatment() {
        return isTreatment;
    }

    @JsonProperty("isTreatment")
    public void setTreatment(boolean treatment) {
        this.isTreatment = treatment;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }
}
