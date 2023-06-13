package com.teja.jpa.customjpa.exception;

public class ApiException extends RuntimeException{

    public ApiException(){

    }
    public ApiException(String message){
        super(message);
    }
}
