package io.github.rafaelsilva91.springsocial.resources;

import io.github.rafaelsilva91.springsocial.dto.CommentDTO;
import io.github.rafaelsilva91.springsocial.entities.Comment;
import io.github.rafaelsilva91.springsocial.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/publicacao/comentarios")
public class CommentResource {

    @Autowired
    private CommentService service;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> findAll(){
        List<Comment> list = service.findAll();
        List<CommentDTO> listDto = list.stream()
                .map(value -> new CommentDTO(value))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable Long id){
        Comment obj = service.findById(id);
        return ResponseEntity.ok().body(new CommentDTO(obj));
    }

    //	@PostMapping
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody CommentDTO objDTO){
        Comment obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody CommentDTO objDTO, @PathVariable Long id){
        Comment obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

}
