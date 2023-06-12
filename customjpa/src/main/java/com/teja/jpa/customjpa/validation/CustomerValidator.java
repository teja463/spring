package com.teja.jpa.customjpa.validation;

import com.teja.jpa.customjpa.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if(customer.getAddress().length()>10){
            errors.reject("address", "address lenght more than 10");
        }
    }
}
