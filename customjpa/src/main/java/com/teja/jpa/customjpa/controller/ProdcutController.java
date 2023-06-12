package com.teja.jpa.customjpa.controller;


import com.teja.jpa.customjpa.dto.CustomerProduct;
import com.teja.jpa.customjpa.dto.ProductRequest;
import com.teja.jpa.customjpa.entity.Customer;
import com.teja.jpa.customjpa.entity.Product;
import com.teja.jpa.customjpa.exception.ApiException;
import com.teja.jpa.customjpa.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdcutController {

    private CustomerRepository customerRepository;

    public ProdcutController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/{id}")
    public void addProduct(@PathVariable Long id, @RequestBody @Valid ProductRequest request){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ApiException("Customer not found with id " + id));
        List<Product> products = customer.getProducts();
        Product product = new Product();
        product.setCustomer(customer);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        products.add(product);
        customerRepository.save(customer);
    }

    @GetMapping
    public List<CustomerProduct> findAllProducts(){
        return customerRepository.findAllProducts();
    }

}
