package io.github.rafaelsilva91.springsocial.dto;

import io.github.rafaelsilva91.springsocial.entities.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = -6652327904990708209L;

    private Long id;
    private String name;

    public AuthorDTO(){

    }

    public AuthorDTO(User obj){
        id = obj.getId();
        name = obj.getName();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
