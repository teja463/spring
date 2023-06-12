package com.teja.jpa.customjpa.validation;


import com.teja.jpa.customjpa.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if(student.getEmail().length()>20){
            errors.reject( "mail_length" ,"length more than 20");
        }
    }
}
