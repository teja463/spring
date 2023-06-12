package com.features.v10;

import java.util.List;

public class LocalTypeInference {
    public static void main(String[] args) {
        var names = List.of("One", "Two", "Three", "Four");
        for(var name: names){
            System.out.println(name);
        }
    }
}
