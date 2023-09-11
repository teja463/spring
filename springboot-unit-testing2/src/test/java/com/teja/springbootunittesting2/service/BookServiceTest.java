package com.teja.springbootunittesting2.service;

import com.teja.springbootunittesting2.entity.Book;
import com.teja.springbootunittesting2.exception.BookNotFoundException;
import com.teja.springbootunittesting2.repository.BookRepository;
import com.teja.springbootunittesting2.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Captor
    ArgumentCaptor<Book> bookArgumentCaptor;

    @Test
    public void getByid_Success() {
        when(bookRepository.findById(1)).thenReturn(Optional.of(new Book(1, "Wings of Fire", "2333", "Abdul Kalam")));
        Optional<Book> book = bookService.getBook(1);
        assertTrue(book.isPresent());
        assertEquals(1, book.get().getId());
    }

    @Test
    public void getById_Exception() {
        when(bookRepository.findById(2)).thenThrow(new BookNotFoundException("Book not found"));
        assertThrows(BookNotFoundException.class, () -> {
            bookService.getBook(2);
        });
    }

    @Test
    public void addBook_Success(){
        Book book = new Book(11, "Test", "test", "Test");
        bookService.addBook(book);
        Mockito.verify(bookRepository, Mockito.times(1)).save(book);
    }

    @Test
    public void addBook_ArgumentCaptor(){
        Book book = new Book(11, "Test", "test", "Test");
        bookService.addBook(book);
        Mockito.verify(bookRepository, Mockito.times(1)).save(bookArgumentCaptor.capture());

        Book savedBook = bookArgumentCaptor.getValue();
        assertEquals(book.getId(), savedBook.getId());
    }

}