package com.teja.springbootunittesting2.service.impl;

import com.teja.springbootunittesting2.entity.Book;
import com.teja.springbootunittesting2.repository.BookRepository;
import com.teja.springbootunittesting2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> getBook(int id){
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
