package com.teja.jpa.customjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class StudentNotFound extends RuntimeException{

    public StudentNotFound(String message){
        super(message);
    }
}
