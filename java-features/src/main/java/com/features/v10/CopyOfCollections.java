package com.features.v10;

import java.util.ArrayList;
import java.util.List;

public class CopyOfCollections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        dontModify(list);
        System.out.println(list);
        List<String> immutableList = List.copyOf(list);
        dontModify(immutableList);
    }

    private static void dontModify(List<String> list){
        list.add("Not allowed");
    }
}
