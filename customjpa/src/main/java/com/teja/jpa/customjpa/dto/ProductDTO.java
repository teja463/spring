package com.teja.jpa.customjpa.dto;

import com.teja.jpa.customjpa.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class ProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Integer productPrice;

    private CustomerDTO customer;

}
