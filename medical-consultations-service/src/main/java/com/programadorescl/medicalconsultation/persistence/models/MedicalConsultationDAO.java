package com.programadorescl.medicalconsultation.persistence.models;

import com.programadorescl.medicalconsultation.domain.entities.PaymentMethod;
import com.programadorescl.medicalconsultation.domain.entities.StatusMedicalConsultation;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medical_consultations")
public class MedicalConsultationDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "pet_id", nullable = false)
    private String petName;

    @Column(name = "id_pet_consultation", nullable = false)
    private String idPetConsultation;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "process_description")
    private String processDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_medical_consultation")
    private StatusMedicalConsultation statusMedicalConsultation;

    @Column(name = "is_treatment")
    private boolean isTreatment;

    @Column(name = "total_amount")
    private Long totalAmount;

    private Long payment;
}
