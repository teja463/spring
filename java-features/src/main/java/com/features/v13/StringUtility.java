package com.features.v13;

public class StringUtility {

    public static void main(String[] args) {
        String s = "Hi, I am %s I am %d years old";
        System.out.println(s.formatted("Teja", 33));
        System.out.println(s.isBlank());
        System.out.println("    Teja     ".strip());
        System.out.println("    Teja     ".stripLeading());
        System.out.println("    Teja     ".stripTrailing());
    }
}
