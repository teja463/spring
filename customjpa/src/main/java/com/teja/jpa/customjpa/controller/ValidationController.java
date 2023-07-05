package com.teja.jpa.customjpa.controller;

import com.teja.jpa.customjpa.entity.Customer;
import com.teja.jpa.customjpa.entity.Student;
import com.teja.jpa.customjpa.exception.StudentNotFound;
import com.teja.jpa.customjpa.repository.CustomerRepository;
import com.teja.jpa.customjpa.repository.StudentRepository;
import com.teja.jpa.customjpa.util.BindingResultUtil;
import com.teja.jpa.customjpa.validation.CustomerValidator;
import com.teja.jpa.customjpa.validation.StudentValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;
    private StudentValidator studentValidator;
    private StudentRepository studentRepository;

    @InitBinder
    private void binder(WebDataBinder binder){
        binder.addValidators(customerValidator);
    }

    public ValidationController(CustomerRepository customerRepository, CustomerValidator customerValidator, StudentValidator studentValidator, StudentRepository studentRepository) {
        this.customerRepository = customerRepository;
        this.customerValidator = customerValidator;
        this.studentValidator = studentValidator;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> all = customerRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> list = BindingResultUtil.constructErrors(bindingResult);
            throw new StudentNotFound(list.toString());
        }
        Customer cust = customerRepository.save(customer);
        return ResponseEntity.ok(cust);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student, BindingResult bindingResult){
        studentValidator.validate(student, bindingResult);
        if(bindingResult.hasErrors()){
            List<String> list = BindingResultUtil.constructErrors(bindingResult);
            throw new StudentNotFound(list.toString());
        }
        return ResponseEntity.created(null).body(studentRepository.save(student));
    }

    @PostMapping(headers = {"version=v2"})
    public ResponseEntity<Student> addStudentV2(@RequestBody @Valid Student student){
        return ResponseEntity.created(null).body(studentRepository.save(student));
    }
}
