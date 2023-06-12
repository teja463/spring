package com.teja.jpa.customjpa.controller;

import com.teja.jpa.customjpa.entity.Customer;
import com.teja.jpa.customjpa.exception.StudentNotFound;
import com.teja.jpa.customjpa.repository.CustomerRepository;
import com.teja.jpa.customjpa.util.BindingResultUtil;
import com.teja.jpa.customjpa.validation.CustomerValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;
    @InitBinder
    private void binder(WebDataBinder binder){
        binder.addValidators(customerValidator);
    }
    public CustomerController(CustomerRepository customerRepository, CustomerValidator customerValidator) {
        this.customerRepository = customerRepository;
        this.customerValidator = customerValidator;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> all = customerRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> list = BindingResultUtil.constructErrors(bindingResult);
            throw new StudentNotFound(list.toString());
        }
        Customer cust = customerRepository.save(customer);
        return ResponseEntity.ok(cust);
    }
}
