package io.github.rafaelsilva91.springsocial.services;

import io.github.rafaelsilva91.springsocial.entities.Post;
import io.github.rafaelsilva91.springsocial.repositories.PostRepository;
import io.github.rafaelsilva91.springsocial.services.exception.ObjectNotFoundException;
import io.github.rafaelsilva91.springsocial.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(Long id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Post insert(Post obj) {
        return repository.save(obj);
    }


    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
//			e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e) {
//			e.printStackTrace();
            throw new ObjectNotFoundException(e.getMessage());
        }

    }


    public Post update(Long id, Post obj) {
        try {
            Post entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e) {
//			e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Post entity, Post obj) {
        entity.setDate(obj.getDate());
        entity.setTitle(obj.getTitle());
        entity.setBody(obj.getBody());
        entity.setAuthor(obj.getAuthor());
    }

}
