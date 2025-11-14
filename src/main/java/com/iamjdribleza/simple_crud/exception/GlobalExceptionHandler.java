package com.iamjdribleza.simple_crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exception if an entity is not found
     * @param e - ResourceNotFoundException Class
     * @return error message along with status
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles exception if an entity is already exists in the database
     * @param e - ResourceAlreadyExists Class
     * @return error message along with status
     */
    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<String> resourceAlreadyExists(ResourceAlreadyExists e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
