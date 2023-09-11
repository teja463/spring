package com.teja.springbootunittesting2.repository;

import com.teja.springbootunittesting2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
