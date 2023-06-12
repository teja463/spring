package com.teja.jpa.customjpa.exception;

import com.teja.jpa.customjpa.advice.ApiExceptionAdvice;

public class ApiException extends RuntimeException{



    public ApiException(){

    }
    public ApiException(String message){
        super(message);
    }
}
