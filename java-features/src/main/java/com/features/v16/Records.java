package com.features.v16;

record User(Integer id, String name, String email){

    public User(String name, String email){
        this(null, name, email);

    }
}

public class Records {
    public static void main(String[] args) {
        User user = new User(10, "Teja", "teja@gmail.com");
        System.out.println(user);
    }
}
