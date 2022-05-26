package io.github.rafaelsilva91.springsocial.services;

import io.github.rafaelsilva91.springsocial.dto.UserDTO;
import io.github.rafaelsilva91.springsocial.entities.User;
import io.github.rafaelsilva91.springsocial.repositories.UserRepository;
import io.github.rafaelsilva91.springsocial.services.exception.ObjectNotFoundException;
import io.github.rafaelsilva91.springsocial.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();

    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
//        User entity = repository.getOne(id);
        try {
            User entity = findById(obj.getId());
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw  new ResourceNotFoundException(obj.getId());
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto ){
        return new User(
                objDto.getId(),
                objDto.getName(),
                objDto.getEmail());
    }



}
