package com.programadorescl.medicalconsultation.persistence;

import com.programadorescl.medicalconsultation.domain.entities.MedicalConsultation;
import com.programadorescl.medicalconsultation.domain.entities.StatusMedicalConsultation;
import com.programadorescl.medicalconsultation.domain.gateways.MedicalConsultationGateway;
import com.programadorescl.medicalconsultation.persistence.crud.MedicalConsultationCrudRepository;
import com.programadorescl.medicalconsultation.persistence.mappers.MedicalConsultationMapper;
import com.programadorescl.medicalconsultation.persistence.models.MedicalConsultationDAO;
import com.programadorescl.medicalconsultation.persistence.models.StatusMedicalConsultationDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MedicalConsultationRepository implements MedicalConsultationGateway {

    @Autowired
    private MedicalConsultationCrudRepository repository;

    @Autowired
    private MedicalConsultationMapper mapper;

    @Override
    public Optional<MedicalConsultation> findById(Long id) {
        return repository.findById(id).map(m -> mapper.toDomainModel(m));
    }

    @Override
    public List<MedicalConsultation> getAll() {
        List<MedicalConsultationDAO> daos = (List<MedicalConsultationDAO>) repository.findAll();
        return mapper.toDomainModels(daos);
    }

    @Override
    public Optional<Long> countPetNameAndStatusMedicalConsultation(String petName) {
        return repository.countPetNameAndStatusMedicalConsultation(petName);
    }

    @Override
    public MedicalConsultation save(MedicalConsultation medicalConsultation) {
        MedicalConsultationDAO dao = mapper.toEntity(medicalConsultation);
        return mapper.toDomainModel(repository.save(dao));
    }

    @Override
    public void delete(MedicalConsultation medicalConsultation) {
        repository.delete(mapper.toEntity(medicalConsultation));
    }

    @Override
    public MedicalConsultation update(MedicalConsultation medicalConsultation) {
        MedicalConsultationDAO dao = mapper.toEntity(findById(medicalConsultation.getId()).get());
        dao.setStatusMedicalConsultation(medicalConsultation.getStatusMedicalConsultation());
        dao.setPaymentMethod(medicalConsultation.getPaymentMethod());
        dao.setTreatment(medicalConsultation.isTreatment());
        BeanUtils.copyProperties(medicalConsultation, dao);
        repository.save(dao);
        return medicalConsultation;
    }
}
