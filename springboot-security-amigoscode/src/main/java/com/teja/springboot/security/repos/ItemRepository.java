package com.teja.springboot.security.repos;

import com.teja.springboot.security.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
