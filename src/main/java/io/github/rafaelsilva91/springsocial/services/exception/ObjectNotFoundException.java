package io.github.rafaelsilva91.springsocial.services.exception;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = -7693795700598512450L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
