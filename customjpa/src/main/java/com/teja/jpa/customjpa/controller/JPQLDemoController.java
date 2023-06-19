package com.teja.jpa.customjpa.controller;

import com.teja.jpa.customjpa.dto.CustomerProduct;
import com.teja.jpa.customjpa.dto.DeptEmpCount;
import com.teja.jpa.customjpa.entity.Customer;
import com.teja.jpa.customjpa.entity.Product;
import com.teja.jpa.customjpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/jpql")
public class JPQLDemoController {

    @Autowired
    EntityManager entityManager;

    @GetMapping
    public ResponseEntity<List<Student>> sample(){
        TypedQuery<Student> query = entityManager.createQuery("Select s from Student s where s.id in :ids", Student.class);
        List<Long> ids = Stream.of(2L, 3L).collect(Collectors.toList());
        query.setParameter("ids", ids);
        List<Student> resultList = query.getResultList();
        return ResponseEntity.ok(resultList);
    }

    @GetMapping("/named-query")
    public ResponseEntity<Student> namedQuery(){
        TypedQuery<Student> query = entityManager.createNamedQuery("findByFirstName", Student.class);
        query.setParameter("firstName", "Havish");

        Student result = query.getSingleResult();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/join-customer")
    public ResponseEntity<List<Customer>> joinQueryCustomer(){
        TypedQuery<Customer> query = entityManager.createQuery("Select c from Customer c join c.products", Customer.class);
        List<Customer> customers = query.getResultList();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/join-product")
    public ResponseEntity<List<Product>> joinQueryProduct(){
        TypedQuery<Product> query = entityManager.createQuery("Select p from Product p left join p.customer", Product.class);
        List<Product> customers = query.getResultList();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/join-product-customer")
    public ResponseEntity<List<CustomerProduct>> joinQueryProductCustomer(){
        TypedQuery<CustomerProduct> query = entityManager.createQuery("Select new com.teja.jpa.customjpa.dto.CustomerProduct(c.name, p.name) from Product p left join p.customer c", CustomerProduct.class);
        List<CustomerProduct> customers = query.getResultList();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/groupby")
    public ResponseEntity<List<DeptEmpCount>> groupBy(){
        TypedQuery<DeptEmpCount> query = entityManager.createQuery("Select new com.teja.jpa.customjpa.dto.DeptEmpCount(d.deptName, count(e.empNo) as empCount) from Employees e join e.departments d group by d.deptName order by empCount", DeptEmpCount.class);
        List<DeptEmpCount> customers = query.getResultList();
        return ResponseEntity.ok(customers);
    }

}
