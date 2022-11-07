package com.programadorescl.userpetservice.infrastructure.adapters.out.user;

import com.programadorescl.userpetservice.application.domains.entities.Pet;
import com.programadorescl.userpetservice.application.domains.entities.User;
import com.programadorescl.userpetservice.application.ports.out.user.UserGateway;
import com.programadorescl.userpetservice.infrastructure.crud.user.UserCrudRepository;
import com.programadorescl.userpetservice.infrastructure.mappers.user.UserMapper;
import com.programadorescl.userpetservice.infrastructure.models.user.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Repository
public class UserRepository implements UserGateway {

    //DI a tráves de lombok por contructor
    //@Autowired por párametro me marca error de bean para el mapper
    private final UserCrudRepository crudRepository;
    private final UserMapper mapper;

    @Override
    public List<User> getAll() {
        List<UserDAO> userDaos = crudRepository.findAllActives();
        return mapper.toDomainModels(userDaos);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return crudRepository.findById(id).map(user -> mapper.toDomainModel(user));
    }

    @Override
    public User saveUser(User user) {
        UserDAO userDao = mapper.toEntity(user);
        return mapper.toDomainModel(crudRepository.save(userDao));
    }

    @Override
    public Boolean deleteUser(Long id) {
        if (this.getUserById(id).isPresent()) {
            crudRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User updateUser(User user) {
        UserDAO userDao = mapper.toEntity(user);
        return mapper.toDomainModel(crudRepository.save(userDao));
    }

    @Override
    public List<Pet> getPetsInfo(Long userId) {
        User userById = crudRepository.findById(userId).map(user -> mapper.toDomainModel(user)).get();
        return userById.getPets();
    }

    @Override
    public User getUserByRut(String rut) {
        return mapper.toDomainModel(crudRepository.findByRutEquals(rut));
    }
}
