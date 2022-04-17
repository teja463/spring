package com.example.springbootunittesting.repos;

import com.example.springbootunittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
