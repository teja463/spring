package com.example.springbootunittesting;

import java.util.Arrays;

public class SomeBusinessImpl implements SomeBusinessClass{

    SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    @Override
    public int add(int[] numbers) {
        return Arrays.stream(numbers).reduce(0, (sum, nextNum) -> sum+nextNum);
    }

    public int addWithService(){
        return Arrays.stream(someDataService.retrieveAllData()).reduce(0, (sum, nextNum) -> sum+nextNum);
    }
}
