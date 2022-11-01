package com.coderJava.jpaservice.controller;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
