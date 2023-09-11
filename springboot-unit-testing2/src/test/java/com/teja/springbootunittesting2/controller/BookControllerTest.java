package com.teja.springbootunittesting2.controller;

import com.teja.springbootunittesting2.entity.Book;
import com.teja.springbootunittesting2.repository.BookRepository;
import com.teja.springbootunittesting2.service.BookService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = BookController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book(1, "test", "anothre", "asdf");
        Book book2 = new Book(2, "test", "anothre", "asdf");
        when(bookService.getAll()).thenReturn(Arrays.asList(book1, book2));

        mockMvc.perform(get("/books"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)));
    }
}