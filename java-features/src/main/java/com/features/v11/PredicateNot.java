package com.features.v11;

import java.util.List;
import java.util.function.Predicate;

public class PredicateNot {

    private static boolean filterEven(Integer num){
        return num%2==0;
    }
    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5,6,7,8,10);
        list.stream().filter(Predicate.not(PredicateNot::filterEven)).forEach(System.out::println);
    }
}
