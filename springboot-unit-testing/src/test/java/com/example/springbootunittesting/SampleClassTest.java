package com.example.springbootunittesting;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class SampleClassTest {

    @Test
    public void testLog(){
        SampleClass c = Mockito.mock(SampleClass.class);
        c.log("Teja");
        Mockito.verify(c).log("Teja");
    }
}
