package com.teja.jpa.customjpa.controller;

import com.teja.jpa.customjpa.entity.Employees;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EntityManager entityManager;

    public EmployeesController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping
    public List<Employees> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employees> criteriaQuery = criteriaBuilder.createQuery(Employees.class);
        Root<Employees> root = criteriaQuery.from(Employees.class);
        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
