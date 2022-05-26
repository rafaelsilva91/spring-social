package io.github.rafaelsilva91.springsocial.services;


import java.util.List;
import java.util.Optional;

import io.github.rafaelsilva91.springsocial.dto.CommentDTO;
import io.github.rafaelsilva91.springsocial.entities.Comment;
import io.github.rafaelsilva91.springsocial.repositories.CommentRepository;
import io.github.rafaelsilva91.springsocial.services.exception.ObjectNotFoundException;
import io.github.rafaelsilva91.springsocial.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> findAll(){
        return repository.findAll();
    }

    public Comment findById(Long id) {
        Optional<Comment> obj = repository.findById(id);
//		return obj.get();
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Comment insert(Comment obj) {
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

    public Comment update(Comment obj) {
        Comment entity = repository.getOne(obj.getId()) ;
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Comment entity, Comment obj) {
        entity.setText(obj.getText());
        entity.setDate(obj.getDate());

    }

    // DTO... aproveitando a injecao de dependencia  da UserService a Repository
    public Comment fromDTO(CommentDTO objDto) {
        return new Comment(objDto.getId(),
                objDto.getText(),
                objDto.getDate(),
                objDto.getAuthor());
    }


}
