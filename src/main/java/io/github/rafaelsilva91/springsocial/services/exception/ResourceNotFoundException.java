package io.github.rafaelsilva91.springsocial.services.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2490690497768200227L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}
