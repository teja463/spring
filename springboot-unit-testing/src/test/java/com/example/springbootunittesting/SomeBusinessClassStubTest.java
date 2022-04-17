package com.example.springbootunittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SomeDataServiceStub implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {4,5,6};
    }
}

class SomeDataServiceStubEmpty implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

class SomeBusinessClassStubTest {

    @Test
    public void addWithServide(){
        SomeBusinessImpl businessClass = new SomeBusinessImpl();
        businessClass.setSomeDataService(new SomeDataServiceStub());
        assertEquals(15, businessClass.addWithService());
    }

    @Test
    public void addWithServide_withZero(){
        SomeBusinessImpl businessClass = new SomeBusinessImpl();
        businessClass.setSomeDataService(new SomeDataServiceStubEmpty());
        assertEquals(0, businessClass.addWithService());
    }
}