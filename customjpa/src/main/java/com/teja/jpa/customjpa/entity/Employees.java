package com.teja.jpa.customjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employees")
@Getter
@Setter
public class Employees {


    @Id
    private Integer empNo;

    private Date birthDate;

    private String firstName;

    private String lastName;

    private String gender;

    private Date hireDate;

    @ManyToMany
    @JoinTable(name="dept_emp",
            joinColumns = @JoinColumn(name = "emp_no"),
            inverseJoinColumns = @JoinColumn(name = "dept_no")
    )
    @JsonIgnore
    private Set<Departments> departments = new HashSet<>();
}
