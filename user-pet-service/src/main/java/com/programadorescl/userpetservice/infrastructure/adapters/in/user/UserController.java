package com.programadorescl.userpetservice.infrastructure.adapters.in.user;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetNotFoundException;
import com.programadorescl.userpetservice.application.services.exceptions.pet.PetWithTreatmentException;
import com.programadorescl.userpetservice.application.services.exceptions.user.DuplicateUserException;
import com.programadorescl.userpetservice.application.services.exceptions.user.UserNotFoundException;
import com.programadorescl.userpetservice.application.services.pet.GetPetByIdService;
import com.programadorescl.userpetservice.application.services.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.programadorescl.userpetservice.infrastructure.utils.Utils.toSingleton;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "v1/users")
public class UserController {

    protected static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private GetAllUsersService getAllUsersService;

    @Autowired
    private GetUserByIdService getUserByIdService;

    @Autowired
    private SaveUserService saveUserService;

    @Autowired
    private DeleteUserByIdService deleteUserByIdService;

    @Autowired
    private GetPetsInfoService getPetsInfoService;

    @Autowired
    private UpdateUserService updateUserService;

    @Autowired
    private GetPetByIdService getPetByIdService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws Exception {
        logger.info(String
                .format("get-user-by-id-service getUserById() invoked:{%s} for {%s} ", getUserByIdService.getClass().getName(),
                        id));
        User user;
        try {
            user = getUserByIdService.execute(id).get();
            user.add(linkTo(methodOn(UserController.class)
                            .getUserById(user.getUserId()))
                            .withSelfRel(),
                    linkTo(methodOn(UserController.class)
                            .getAll())
                            .withRel("getAll"),
                    linkTo(methodOn(UserController.class)
                            .saveUser(user))
                            .withRel("saveUser"),
                    linkTo(methodOn(UserController.class)
                            .deleteUser(user.getUserId()))
                            .withRel("deleteUser"),
                    linkTo(methodOn(UserController.class)
                            .updateUser(user))
                            .withRel("updateUser")
            );

        } catch (UserNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getUserById REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getUserById REST Call", ex);
            throw ex;
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Collection<User>> getAll() throws Exception {
        logger.info(String
                .format("get-all-user-service getAll() invoked:{%s} for {%s} ", getAllUsersService.getClass().getName(),
                        "ALL"));
        Collection<User> users;
        try {
            users = getAllUsersService.execute(null);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getAll REST Call", ex);
            throw ex;
        }
        return users.size() > 0 ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws Exception {
        logger.info(String
                .format("save-user-service saveUser() invoked:{%s} for {%s} ", saveUserService.getClass().getName(),
                        user));
        User userResponse;
        try {
            userResponse = saveUserService.execute(user);
        } catch (DuplicateUserException ex) {
            logger.log(Level.WARNING, "Exception raised saveUser REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised saveUser REST Call", ex);
            throw ex;
        }
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) throws Exception {
        logger.info(String
                .format("delete-user-service saveUser() invoked:{%s} for {%s} ", deleteUserByIdService.getClass().getName(),
                        id));
        Boolean isUser;

        try {
            isUser = deleteUserByIdService.execute(id);
        } catch (UserNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised deleteUser REST Call", ex);
            throw ex;
        } catch (PetWithTreatmentException ex) {
            logger.log(Level.WARNING, "Exception raised deleteUser REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised deleteUser REST Call {0}", ex);
            throw ex;
        }

        if (isUser) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
        logger.info(String
                .format("delete-user-service updateUser() invoked:{%s} for {%s} ", updateUserService.getClass().getName(),
                        user.getUserId()));
        User userResponse;
        try {
            userResponse = updateUserService.execute(user);

        } catch (UserNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised updateUser REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised updateUser REST Call {0}", ex);
            throw ex;
        }
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/pet/{name}/userId/{userId}")
    public ResponseEntity<Pet> getPetInfo(@PathVariable("name") String name, @PathVariable("userId") Long userId)
            throws Exception {
        logger.info(String
                .format("delete-user-service getPetInfo() invoked:{%s} for {%s} ", getPetsInfoService.getClass().getName(),
                        userId));
        List<Pet> pets;
        try {
            pets = getPetsInfoService.execute(userId);
            getPetByIdService.execute(name);

        } catch (UserNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getPetInfo REST Call", ex);
            throw ex;
        } catch (PetNotFoundException ex) {
            logger.log(Level.WARNING, "Exception raised getPetInfo REST Call", ex);
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised getPetInfo REST Call {0}", ex);
            throw ex;
        }
        Pet resultPet = pets.stream()
                .filter(pet -> pet.getName().equals(name))
                .collect(toSingleton());
        return new ResponseEntity<>(resultPet, HttpStatus.OK);
    }
}
