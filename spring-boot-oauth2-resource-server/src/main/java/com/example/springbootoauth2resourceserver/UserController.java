package com.example.springbootoauth2resourceserver;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @GetMapping
    public String sample(){
        return "Sample user";
    }
}
