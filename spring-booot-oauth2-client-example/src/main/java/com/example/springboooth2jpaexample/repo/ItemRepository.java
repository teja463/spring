package com.example.springboooth2jpaexample.repo;

import com.example.springboooth2jpaexample.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
