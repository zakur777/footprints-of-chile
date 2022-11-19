package com.programadorescl.petconsultation.resources;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.programadorescl.petconsultation.common.DuplicateVeterinaryException;
import com.programadorescl.petconsultation.common.VeterinaryNotFoundException;
import com.programadorescl.petconsultation.domain.model.entity.Veterinary;
import com.programadorescl.petconsultation.domain.service.VeterinaryService;
import com.programadorescl.petconsultation.domain.valueobject.VeterinaryVO;
import java.util.ArrayList;
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
@RequestMapping(value = "v1/veterinarians")
public class VeterinaryController {

    protected static final Logger logger = Logger.getLogger(VeterinaryController.class.getName());

    @Autowired private VeterinaryService veterinaryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeterinaryVO> findById(@PathVariable("id") String id) throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service findById() invoked: %s for %s",
                        veterinaryService.getClass().getName(), id));
        Veterinary veterinary;
        VeterinaryVO veterinaryVO = new VeterinaryVO();
        try {
            veterinary = veterinaryService.findById(id);
            BeanUtils.copyProperties(veterinary, veterinaryVO);
            veterinaryVO.setId(veterinary.getId());
            veterinaryVO.add(
                    linkTo(methodOn(VeterinaryController.class).findById(veterinaryVO.getId()))
                            .withSelfRel(),
                    linkTo(methodOn(VeterinaryController.class).findALL()).withRel("findALL"),
                    linkTo(methodOn(VeterinaryController.class).add(veterinaryVO)).withRel("add"),
                    linkTo(
                                    methodOn(VeterinaryController.class)
                                            .delete(veterinary.getProfessionalLicense()))
                            .withRel("delete"),
                    linkTo(methodOn(VeterinaryController.class).update(veterinaryVO))
                            .withRel("update"),
                    linkTo(
                                    methodOn(VeterinaryController.class)
                                            .findByProfessionalLicense(
                                                    veterinary.getProfessionalLicense()))
                            .withRel("findByProfessionalLicense"));

        } catch (VeterinaryNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(veterinaryVO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Veterinary> add(@RequestBody VeterinaryVO veterinaryVO) throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service add() invoked: %s for %s",
                        veterinaryService.getClass().getName(), veterinaryVO.getName()));
        System.out.println(veterinaryVO);
        Veterinary veterinary = Veterinary.getDummyVeterinary();
        BeanUtils.copyProperties(veterinaryVO, veterinary);
        try {
            veterinaryService.add(veterinary);

        } catch (DuplicateVeterinaryException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Veterinary> update(@RequestBody VeterinaryVO veterinaryVO)
            throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service update() invoked: %s for %s",
                        veterinaryService.getClass().getName(), veterinaryVO.getName()));
        System.out.println(veterinaryVO);
        Veterinary veterinary = Veterinary.getDummyVeterinary();
        BeanUtils.copyProperties(veterinaryVO, veterinary);
        try {
            veterinaryService.update(veterinary);

        } catch (VeterinaryNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(veterinary, HttpStatus.OK);
    }

    // TODO HATEOAS - DOCKER - OPENAPI

    @GetMapping(value = "/all")
    public ResponseEntity<List<Veterinary>> findALL() throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service findALL() invoked: %s for %s",
                        veterinaryService.getClass().getName(), "GETALL"));
        List<Veterinary> veterinaryList = new ArrayList<>();
        try {
            veterinaryList = veterinaryService.findALL();

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(veterinaryList, HttpStatus.OK);
    }

    @GetMapping(value = "license/{license}")
    public ResponseEntity<Veterinary> findByProfessionalLicense(
            @PathVariable("license") String license) throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service findByProfessionalLicense() invoked: %s for %s",
                        veterinaryService.getClass().getName(), license));
        System.out.println(license);
        Veterinary veterinary;
        try {
            veterinary = veterinaryService.findByProfessionalLicense(license);

        } catch (VeterinaryNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(veterinary, HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{license}")
    public ResponseEntity<Veterinary> delete(@PathVariable("license") String license)
            throws Exception {
        logger.info(
                String.format(
                        "pet-consultation-service delete() invoked: %s for %s",
                        veterinaryService.getClass().getName(), license));
        try {
            veterinaryService.delete(license);

        } catch (VeterinaryNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised add Booking REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*



    public void delete(String id) throws Exception;

    */
}
