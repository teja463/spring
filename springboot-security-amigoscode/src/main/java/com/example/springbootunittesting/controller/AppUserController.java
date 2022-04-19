package com.example.springbootunittesting.controller;

import com.example.springbootunittesting.model.AppUser;
import com.example.springbootunittesting.repos.AppUserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class AppUserController {

    private final AppUserRepository appUserRepository;

    public AppUserController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<AppUser> getAllUsers(){
        return appUserRepository.findAll();
    }
}
