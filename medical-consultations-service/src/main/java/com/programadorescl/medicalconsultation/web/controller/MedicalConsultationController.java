package com.programadorescl.medicalconsultation.web.controller;

import com.programadorescl.medicalconsultation.domain.entities.MedicalConsultation;
import com.programadorescl.medicalconsultation.domain.exception.*;
import com.programadorescl.medicalconsultation.domain.services.MedicalConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/medialConsultations")
public class MedicalConsultationController {

    protected static final Logger logger =
            Logger.getLogger(MedicalConsultationController.class.getName());

    private final MedicalConsultationService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicalConsultation> findById(@PathVariable Long id) throws Exception {
        logger.info(
                String.format(
                        "get-user-by-id-service getUserById() invoked:{%s} for {%s} ",
                        service.getClass().getName(), id));
        MedicalConsultation medicalConsultation;

        try {
            medicalConsultation = service.findById(id).get();
            medicalConsultation.add(
                    linkTo(
                            methodOn(MedicalConsultationController.class)
                                    .findById(medicalConsultation.getId()))
                            .withSelfRel(),
                    linkTo(methodOn(MedicalConsultationController.class).getAll()).withRel("getAll"),
                    linkTo(methodOn(MedicalConsultationController.class).save(medicalConsultation))
                            .withRel("save"),
                    linkTo(methodOn(MedicalConsultationController.class).delete(id)).withRel("delete"),
                    linkTo(methodOn(MedicalConsultationController.class).update(medicalConsultation))
                            .withRel("updateUser"));
        } catch (MedicalConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getUserById REST Call", ex);
            throw ex;
        }

        return new ResponseEntity<>(medicalConsultation, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<MedicalConsultation> save(
            @RequestBody MedicalConsultation medicalConsultation) throws Exception {
        try {
            // TODO no se porque me guarda 2 veces ??
            MedicalConsultation save = service.save(medicalConsultation);
        } catch (MedicalConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (PetConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (UserNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;

        } catch (PetNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (NotFoundException ex) {
            Object[] args = {medicalConsultation.getUserId()};
            throw new UserNotFoundException("userNotFound", args);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getUserById REST Call", ex);
            throw ex;
        }
        return new ResponseEntity<>(service.save(medicalConsultation), HttpStatus.OK);
    }

    @GetMapping(value = {"/all"})
    public ResponseEntity<List<MedicalConsultation>> getAll() throws Exception {
        List<MedicalConsultation> serviceAll;
        try {
            serviceAll = service.getAll();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getUserById REST Call", ex);
            throw ex;
        }
        return new ResponseEntity<>(serviceAll, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) throws Exception {
        try {
            service.delete(id);
        } catch (MedicalConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (ConsultOpenOrUnderTreatmentException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getUserById REST Call", ex);
            throw ex;
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<MedicalConsultation> update(
            @RequestBody MedicalConsultation medicalConsultation) throws Exception {
        MedicalConsultation consultation;
        try {
            consultation = service.update(medicalConsultation);
        } catch (MedicalConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (PetConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (UserNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;

        } catch (PetNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getUserById REST Call", ex);
            throw ex;
        }

        return new ResponseEntity<>(consultation, HttpStatus.OK);
    }
}
