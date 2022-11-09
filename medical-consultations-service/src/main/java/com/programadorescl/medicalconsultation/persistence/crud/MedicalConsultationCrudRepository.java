package com.programadorescl.medicalconsultation.persistence.crud;

import com.programadorescl.medicalconsultation.domain.entities.StatusMedicalConsultation;
import com.programadorescl.medicalconsultation.persistence.models.MedicalConsultationDAO;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MedicalConsultationCrudRepository extends CrudRepository<MedicalConsultationDAO, Long> {
    @Query("SELECT COUNT(m) from MedicalConsultationDAO m where m.petName=:petName and m.statusMedicalConsultation = 'OPEN'")
    Optional<Long> countPetNameAndStatusMedicalConsultation(@Param("petName") String petName);


}
