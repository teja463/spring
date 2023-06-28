package com.teja.jpa.customjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO implements Serializable {

    public StudentDTO(Long studentId, String firstName, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.email = email;
    }

    private Long studentId;
    private String firstName;
    private String email;
}
