package io.github.rafaelsilva91.springsocial.dto;

import io.github.rafaelsilva91.springsocial.entities.User;

import java.io.Serializable;
import java.util.Optional;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = -6652327904990708209L;

    private Long id;
    private String name;
    private String email;

    public UserDTO(){

    }

    public UserDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
