package com.teja.jpa.customjpa.advice;

import com.teja.jpa.customjpa.exception.ErrorMessage;
import com.teja.jpa.customjpa.exception.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> requestValidation(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> errors = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }


    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ErrorMessage> studentNotFound(StudentNotFound ex){
        ErrorMessage error = new ErrorMessage(ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
