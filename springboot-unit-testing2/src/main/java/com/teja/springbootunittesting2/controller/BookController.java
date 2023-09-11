package com.teja.springbootunittesting2.controller;

import com.teja.springbootunittesting2.entity.Book;
import com.teja.springbootunittesting2.exception.BookNotFoundException;
import com.teja.springbootunittesting2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id){
        return bookService.getBook(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
}
