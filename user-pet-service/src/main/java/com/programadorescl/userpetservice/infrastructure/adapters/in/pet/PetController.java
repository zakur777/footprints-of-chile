package com.programadorescl.userpetservice.infrastructure.adapters.in.pet;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.services.exceptions.pet.DuplicatePetException;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetNotFoundException;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetWithTreatmentException;
import com.programadorescl.userpetservice.application.services.pet.*;
import com.programadorescl.userpetservice.infrastructure.adapters.in.user.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "v1/pets")
public class PetController {

    protected static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private GetAllPetsService getAllPetsService;

    @Autowired
    private GetPetByIdService getPetByIdService;

    @Autowired
    private SavePetService savePetService;

    @Autowired
    private DeletePetByIdService deletePetByIdService;

    @Autowired
    private UpdatePetService updatePetService;

    @Autowired
    private FindByBredOrNameService findByBredOrNameService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pet> getPetById(@PathVariable("id") String name) throws Exception {
        logger.info(String
                .format("get-pet-by-id-service getPetById() invoked:{%s} for {%s} ",
                        getAllPetsService.getClass().getName(),
                        name));
        Optional<Pet> petOptional;
        Pet pet;
        try {
            pet = getPetByIdService.execute(name).get();
            pet.add(linkTo(methodOn(PetController.class)
                            .getPetById(pet.getName()))
                            .withSelfRel(),
                    linkTo(methodOn(PetController.class)
                            .getAll())
                            .withRel("getAll"),
                    linkTo(methodOn(PetController.class)
                            .savePet(pet))
                            .withRel("savePet"),
                    linkTo(methodOn(PetController.class)
                            .deletePet(pet.getName()))
                            .withRel("deletePet"),
                    linkTo(methodOn(PetController.class)
                            .update(pet))
                            .withRel("update")
            );
        } catch (PetNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getUserById REST Call", ex);
            throw ex;
        }
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getAll() throws Exception {
        logger.info(String
                .format("get-all-pet-service getAll() invoked:{%s} for {%s} ", getAllPetsService.getClass().getName(),
                        "ALL"));
        List<Pet> pets;
        try {
            pets = getAllPetsService.execute(null);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getAll REST Call", ex);
            throw ex;
        }
        return pets.size() > 0 ? new ResponseEntity<>(pets, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/save")
    public ResponseEntity<Pet> savePet(@RequestBody Pet pet) throws Exception {
        logger.info(String
                .format("save-pet-service savePet() invoked:{%s} for {%s} ", savePetService.getClass().getName(),
                        pet));
        Pet petResponse;
        try {
            petResponse = savePetService.execute(pet);

        } catch (DuplicatePetException ex) {
            logger.log(Level.WARNING, "Exception raised saveUser REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised saveUser REST Call", ex);
            throw ex;
        }
        return new ResponseEntity<>(petResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Boolean> deletePet(@PathVariable("name") String name) throws Exception {
        logger.info(String
                .format("delete-pet-service deletePet() invoked:{%s} for {%s} ",
                        deletePetByIdService.getClass().getName(),
                        name));
        Boolean isPetDeleted;
        try {
            isPetDeleted = deletePetByIdService.execute(name);
        } catch (PetNotFoundException | PetWithTreatmentException ex) {
            logger.log(Level.WARNING, "Exception raised deleteUser REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised deleteUser REST Call {0}", ex);
            throw ex;
        }
        if (isPetDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Pet> update(@RequestBody Pet pet) throws Exception {
        logger.info(String
                .format("update-pet-service updatePet() invoked:{%s} for {%s} ", updatePetService.getClass().getName(),
                        pet.getName()));
        Pet petResponse;
        try {
            petResponse = updatePetService.execute(pet);
        } catch (PetNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised updateUser REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised updateUser REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(petResponse, HttpStatus.OK);
    }

    @GetMapping("/findByBredOrName")
    public ResponseEntity<List<Pet>> findPetsByBredOrName(@RequestParam(required = true, name = "param") String param)
            throws Exception {
        logger.info(String
                .format("find-pet-by-breed-or-name-service findPetsByBredOrName() invoked:{%s} for {%s} ",
                        findByBredOrNameService.getClass().getName(),
                        param));
        List<Pet> pets;
        try {
            pets = findByBredOrNameService.execute(param);
        } catch (PetNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised updateUser REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised updateUser REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
}
