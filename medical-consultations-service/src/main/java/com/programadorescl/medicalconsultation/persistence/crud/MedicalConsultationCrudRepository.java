package com.programadorescl.medicalconsultation.persistence.crud;

import com.programadorescl.medicalconsultation.persistence.models.MedicalConsultationDAO;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MedicalConsultationCrudRepository
        extends CrudRepository<MedicalConsultationDAO, Long> {
    @Query(
            "SELECT COUNT(m) from MedicalConsultationDAO m where m.petName=:petName and m.statusMedicalConsultation = 'OPEN'")
    Optional<Long> countPetNameAndStatusMedicalConsultation(@Param("petName") String petName);
}
