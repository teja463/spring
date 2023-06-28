package com.teja.jpa.customjpa.controller;


import com.teja.jpa.customjpa.dto.CustomerProduct;
import com.teja.jpa.customjpa.dto.ProductRequest;
import com.teja.jpa.customjpa.entity.Customer;
import com.teja.jpa.customjpa.entity.Product;
import com.teja.jpa.customjpa.exception.ApiException;
import com.teja.jpa.customjpa.mapstruct.ProductMapper;
import com.teja.jpa.customjpa.repository.CustomerRepository;
import com.teja.jpa.customjpa.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CustomerRepository customerRepository;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductController(CustomerRepository customerRepository, ProductMapper productMapper, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/join")
    public List<CustomerProduct> findAllProducts(){
        return customerRepository.findAllProducts();
    }

    @PostMapping("/{id}")
    public void addProduct(@PathVariable Long id, @RequestBody @Valid ProductRequest request){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ApiException("Customer not found with id " + id));
        List<Product> products = customer.getProducts();
        Product product = productMapper.mapProductRequestToProduct(request);
        product.setCustomer(customer);
        products.add(product);
        customerRepository.save(customer);
    }


}
