package com.teja.jpa.customjpa.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Long customerId;
    private String customerName;
    private String customerAddress;

}
