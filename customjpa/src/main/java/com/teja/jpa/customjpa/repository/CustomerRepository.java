package com.teja.jpa.customjpa.repository;

import com.teja.jpa.customjpa.dto.CustomerProduct;
import com.teja.jpa.customjpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("""
            Select new com.teja.jpa.customjpa.dto.CustomerProduct(c.name, p.name) from Customer c join c.products p
            """)
    public List<CustomerProduct> findAllProducts();
}
