package com.teja.springbootunittesting2.repository;

import com.teja.springbootunittesting2.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void addBook(){
        Book book = new Book (null, "test", "Test", "Tst");
        Book book2 = new Book (null, "test2", "Test2", "Tst2");
        Book savedBook = bookRepository.save(book);
        bookRepository.save(book2);
        assertNotNull(savedBook.getId());
    }

    @Test
    public void findBook(){
        Optional<Book> byId = bookRepository.findById(1);
        assertTrue(byId.isPresent());
        assertEquals(1, byId.get().getId());
    }
}