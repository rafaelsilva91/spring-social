package io.github.rafaelsilva91.springsocial.resources.exceptions;

import io.github.rafaelsilva91.springsocial.services.exception.ObjectNotFoundException;
import io.github.rafaelsilva91.springsocial.services.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<StandardError> resourceNotFund(ResourceNotFoundException e, HttpServletRequest request){
            String error = "Recurso não encontrado!";
            HttpStatus status = HttpStatus.NOT_FOUND;
            StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }

        @ExceptionHandler(ObjectNotFoundException.class)
        public ResponseEntity<StandardError> database(ObjectNotFoundException e, HttpServletRequest request){
            String error = "Database error";
            HttpStatus status = HttpStatus.BAD_REQUEST;
            StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }
}
