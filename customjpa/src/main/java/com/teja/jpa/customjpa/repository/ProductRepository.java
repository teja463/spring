package com.teja.jpa.customjpa.repository;

import com.teja.jpa.customjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
