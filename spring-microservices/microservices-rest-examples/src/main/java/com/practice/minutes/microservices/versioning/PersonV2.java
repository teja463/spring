package com.practice.minutes.microservices.versioning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonV2 {

    private String firstName;
    private String lastName;
}
