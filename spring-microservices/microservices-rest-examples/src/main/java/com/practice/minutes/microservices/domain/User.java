package com.practice.minutes.microservices.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min=2)
    private String name;
    @Past
    private Date dob;

    public User(){}

    public User(@Size(min = 2) String name, @Past Date dob) {
        this.name = name;
        this.dob = dob;
    }

    public User(Integer id, @Size(min = 2) String name, @Past Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }
}
