package com.example.springbootunittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessClassTest {

    SomeBusinessClass businessClass;

    @BeforeEach
    public void init(){
        businessClass = new SomeBusinessImpl();
    }

    @Test
    public void addNumbers(){
        assertEquals(6, businessClass.add(new int[]{1,2,3}));
    }

    @Test
    public void addNumbers_Empty(){
        assertEquals(0, businessClass.add(new int[]{}));
    }

    @Test
    public void addNumbers_NullPointer(){
        assertThrows(NullPointerException.class, () -> { businessClass.add(null);});
    }

}