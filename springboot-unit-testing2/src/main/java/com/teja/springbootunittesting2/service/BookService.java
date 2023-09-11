package com.teja.springbootunittesting2.service;

import com.teja.springbootunittesting2.entity.Book;
import com.teja.springbootunittesting2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {


    Optional<Book> getBook(int id);

    public Book addBook(Book book);

    public List<Book> getAll();
}
