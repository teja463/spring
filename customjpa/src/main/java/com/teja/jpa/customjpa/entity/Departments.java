package com.teja.jpa.customjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="departments")
@Getter
@Setter
public class Departments {

    @Id
    private String deptNo;

    private String deptName;

    @ManyToMany(mappedBy = "departments")
    @JsonIgnore
    private Set<Employees> employees = new HashSet<>();
}
