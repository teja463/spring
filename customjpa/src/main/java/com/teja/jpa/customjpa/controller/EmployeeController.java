package com.teja.jpa.customjpa.controller;

import com.teja.jpa.customjpa.entity.Employees;
import com.teja.jpa.customjpa.repository.EmployeesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @PersistenceContext
    private EntityManager entityManager;

    private final EmployeesRepository employeesRepository;

    public EmployeeController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @GetMapping("/jpa")
    public List<Employees> getAll(){
        return employeesRepository.findAll();
    }
}
