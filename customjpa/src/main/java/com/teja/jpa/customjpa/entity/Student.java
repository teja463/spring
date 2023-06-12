package com.teja.jpa.customjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    public Student(Long id, String firstName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 10)
    private String firstName;

    @NotNull(message = "Lastname cant be null")
    private String lastName;

    @Max(value = 999, message = "Maximum value is 999")
    private Integer totalMarks;

    @Email(message = "Enter valid email")
    private String email;
}
