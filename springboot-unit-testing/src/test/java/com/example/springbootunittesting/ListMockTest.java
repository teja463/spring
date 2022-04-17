package com.example.springbootunittesting;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void sizeTest(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void getTest(){
        when(mock.get(0)).thenReturn("Teja");
        assertEquals("Teja", mock.get(0));
    }

    @Test
    public void anyIntTest(){
        when(mock.get(anyInt())).thenReturn("Teja");
        assertEquals("Teja", mock.get(10));
        assertEquals("Teja", mock.get(101));
    }

    @Test
    public void verifyTest(){
        mock.add("Teja");
        verify(mock, times(1)).add("Teja");
    }
}
