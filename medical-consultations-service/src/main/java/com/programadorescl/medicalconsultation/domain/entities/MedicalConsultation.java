package com.programadorescl.medicalconsultation.domain.entities;

public class MedicalConsultation {
    private int id;
    private int userId;
    private int petId;
    private int idPetConsultation;
    private User user;
    private PetConsultation petConsultation;
    private Pet pet;
    private String paymentMethod;
    private String ProcessDescription;
    private String statusMedicalConsultation;
    private boolean isIsTreatment;
    private int totalAmount;

    public MedicalConsultation() {

    }

    public MedicalConsultation(int id, int userId, int petId, int idPetConsultation, User user, PetConsultation petConsultation, Pet pet, String paymentMethod, String processDescription, String statusMedicalConsultation, boolean isIsTreatment, int totalAmount) {
        this.id = id;
        this.userId = userId;
        this.petId = petId;
        this.idPetConsultation = idPetConsultation;
        this.user = user;
        this.petConsultation = petConsultation;
        this.pet = pet;
        this.paymentMethod = paymentMethod;
        ProcessDescription = processDescription;
        this.statusMedicalConsultation = statusMedicalConsultation;
        this.isIsTreatment = isIsTreatment;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getIdPetConsultation() {
        return idPetConsultation;
    }

    public void setIdPetConsultation(int idPetConsultation) {
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProcessDescription() {
        return ProcessDescription;
    }

    public void setProcessDescription(String processDescription) {
        ProcessDescription = processDescription;
    }

    public String getStatusMedicalConsultation() {
        return statusMedicalConsultation;
    }

    public void setStatusMedicalConsultation(String statusMedicalConsultation) {
        this.statusMedicalConsultation = statusMedicalConsultation;
    }

    public boolean isIsTreatment() {
        return isIsTreatment;
    }

    public void setIsTreatment(boolean isTreatment) {
        isIsTreatment = isTreatment;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
