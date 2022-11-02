package com.coderJava.jpaservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExcepsion {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String>ResourceNotFoundException(Exception ex){
        return new ResponseEntity<>("Lo que buscas no existe",HttpStatus.NOT_FOUND);
    }
}
