package com.example.springbootunittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class SomeBusinessClassMockTest {

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    SomeDataService someDataServiceMock;

    @Test
    public void add() {
        Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3, 4});
        assertEquals(10, business.addWithService());
    }

    @Test
    public void add_Single() {
        Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1});
        assertEquals(1, business.addWithService());
    }

    @Test
    public void add_Exception(){
        Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> business.addWithService());
    }
}