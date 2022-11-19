package com.programadorescl.petconsultation.resources;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.programadorescl.petconsultation.common.DuplicatePetConsultationException;
import com.programadorescl.petconsultation.common.PetConsultationNotFoundException;
import com.programadorescl.petconsultation.domain.model.entity.PetConsultation;
import com.programadorescl.petconsultation.domain.service.PetConsultationService;
import com.programadorescl.petconsultation.domain.valueobject.PetConsultationVO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/petConsultation")
public class PetConsultationController {

    protected static final Logger logger =
            Logger.getLogger(PetConsultationController.class.getName());

    @Autowired private PetConsultationService petConsultationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PetConsultationVO> findById(@PathVariable("id") String id)
            throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service findById() invoked: %s for %s",
                        petConsultationService.getClass().getName(), id));
        PetConsultation petConsultation;
        PetConsultationVO petConsultationVO = new PetConsultationVO();
        try {
            petConsultation = petConsultationService.findById(id);
            BeanUtils.copyProperties(petConsultation, petConsultationVO);
            petConsultationVO.setId(petConsultation.getId());
            petConsultationVO.add(
                    linkTo(
                                    methodOn(PetConsultationController.class)
                                            .findById(petConsultationVO.getId()))
                            .withSelfRel(),
                    linkTo(methodOn(PetConsultationController.class).findALL()).withRel("findALL"),
                    linkTo(methodOn(PetConsultationController.class).add(petConsultationVO))
                            .withRel("add"),
                    linkTo(
                                    methodOn(PetConsultationController.class)
                                            .delete(petConsultationVO.getNationalRegistry()))
                            .withRel("delete"),
                    linkTo(methodOn(PetConsultationController.class).update(petConsultationVO))
                            .withRel("update"),
                    linkTo(
                                    methodOn(PetConsultationController.class)
                                            .findByNationalRegistry(
                                                    petConsultationVO.getNationalRegistry()))
                            .withRel("findByNationalRegistry"));

        } catch (PetConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(petConsultationVO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PetConsultation> add(@RequestBody PetConsultationVO petConsultationVO)
            throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service add() invoked: %s for %s",
                        petConsultationService.getClass().getName(), petConsultationVO.getName()));
        System.out.println(petConsultationVO);
        PetConsultation petConsultation = PetConsultation.getDummyPetConsultation();
        BeanUtils.copyProperties(petConsultationVO, petConsultation);
        petConsultation.setCertificate(petConsultationVO.isIsCertificate());
        try {
            petConsultationService.add(petConsultation);

        } catch (DuplicatePetConsultationException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<PetConsultation> update(@RequestBody PetConsultationVO petConsultationVO)
            throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service update() invoked: %s for %s",
                        petConsultationService.getClass().getName(), petConsultationVO.getName()));
        System.out.println(petConsultationVO);
        PetConsultation petConsultation = PetConsultation.getDummyPetConsultation();
        BeanUtils.copyProperties(petConsultationVO, petConsultation);
        try {
            petConsultationService.update(petConsultation);

        } catch (PetConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(petConsultation, HttpStatus.OK);
    }

    // TODO HATEOAS - DOCKER - OPENAPI

    @GetMapping(value = "/all")
    public ResponseEntity<List<PetConsultation>> findALL() throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service findALL() invoked: %s for %s",
                        petConsultationService.getClass().getName(), "GETALL"));
        List<PetConsultation> petConsultationList;
        try {
            petConsultationList = petConsultationService.findALL();

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(petConsultationList, HttpStatus.OK);
    }

    @GetMapping(value = "nationalRegistry/{nationalRegistry}")
    public ResponseEntity<PetConsultation> findByNationalRegistry(
            @PathVariable("nationalRegistry") String nationalRegistry) throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service findByProfessionalLicense() invoked: %s for %s",
                        petConsultationService.getClass().getName(), nationalRegistry));
        System.out.println(nationalRegistry);
        PetConsultation petConsultation;
        try {
            petConsultation = petConsultationService.findByNationalRegistry(nationalRegistry);

        } catch (PetConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(petConsultation, HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{nationalRegistry}")
    public ResponseEntity<PetConsultation> delete(
            @PathVariable("nationalRegistry") String nationalRegistry) throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service delete() invoked: %s for %s",
                        petConsultationService.getClass().getName(), nationalRegistry));
        try {
            petConsultationService.delete(nationalRegistry);

        } catch (PetConsultationNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
