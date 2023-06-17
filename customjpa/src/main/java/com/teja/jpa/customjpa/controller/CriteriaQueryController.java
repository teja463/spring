package com.teja.jpa.customjpa.controller;

import com.teja.jpa.customjpa.dto.DeptEmpCount;
import com.teja.jpa.customjpa.dto.EmployeeDTO;
import com.teja.jpa.customjpa.dto.StudentInfo;
import com.teja.jpa.customjpa.entity.Departments;
import com.teja.jpa.customjpa.entity.Employees;
import com.teja.jpa.customjpa.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/criteria")
public class CriteriaQueryController {

    private final EntityManager entityManager;

    public CriteriaQueryController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping
    public List<Student> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(root);
        List<Student> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @GetMapping("/selectone")
    public List<String> getStudentNames() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(root.get("firstName"));

        List<String> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @GetMapping("/multiselect")
    public List<Student> getStudentInfo() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.multiselect(root.get("firstName"), root.get("totalMarks"));

        List<Student> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @GetMapping("/constructor")
    public List<StudentInfo> getStudentRecord() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentInfo> criteriaQuery = criteriaBuilder.createQuery(StudentInfo.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(criteriaBuilder.construct(StudentInfo.class, root.get("firstName"), root.get("lastName"), root.get("totalMarks")));
        List<StudentInfo> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return resultList;
    }

    @GetMapping("/where/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("firstName"), name));
        List<Student> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @GetMapping("/in")
    public List<Student> getStudentIn() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(root);
        Path<Object> id = root.get("id");
        Predicate in = id.in(Stream.of(1, 2, 3).collect(Collectors.toList()));
        criteriaQuery.where(in);

        List<Student> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @GetMapping("/join")
    public List<EmployeeDTO> getEmpDeptCriteria(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeDTO> criteriaQuery = criteriaBuilder.createQuery(EmployeeDTO.class);
        Root<Employees> root = criteriaQuery.from(Employees.class);
        Join<Employees, Departments> departments = root.join("departments");
        criteriaQuery.select(criteriaBuilder.construct(EmployeeDTO.class,root.get("empNo"), root.get("firstName"), departments.get("deptName")));
        criteriaQuery.where(criteriaBuilder.equal(departments.get("deptName"), "Finance"));
        List<EmployeeDTO> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @GetMapping("/groupby")
    public List<DeptEmpCount> groupBy(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DeptEmpCount> criteriaQuery = criteriaBuilder.createQuery(DeptEmpCount.class);
        Root<Employees> root = criteriaQuery.from(Employees.class);
        Join<Employees, Departments> departments = root.join("departments");
        Expression<Long> empCount = criteriaBuilder.count(root.get("empNo"));
        criteriaQuery.select(criteriaBuilder.construct(DeptEmpCount.class, departments.get("deptName"), empCount.alias("empCount")));
        criteriaQuery.groupBy(departments.get("deptName"));
        criteriaQuery.orderBy(criteriaBuilder.asc(empCount));
        List<DeptEmpCount> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

}
