package com.example.springbootunittesting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/mylogin")
    public String getLoginPage(){
        return "login";
    }
}
