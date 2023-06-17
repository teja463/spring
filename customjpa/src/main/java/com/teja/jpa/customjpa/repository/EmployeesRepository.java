package com.teja.jpa.customjpa.repository;

import com.teja.jpa.customjpa.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}
