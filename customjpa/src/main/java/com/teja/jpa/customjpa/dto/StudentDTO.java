package com.teja.jpa.customjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO implements Serializable {

    public StudentDTO(Long id, String firstName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
    }

    private Long id;
    private String firstName;
    private String email;
}
