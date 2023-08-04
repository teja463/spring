package com.teja.springboot.security.controller;

import com.teja.springboot.security.model.Reservation;
import com.teja.springboot.security.repos.ReservationRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mgmt/students")
public class StudentManagementController {

    private final ReservationRepository reservationRepository;

    public StudentManagementController(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void addUser(){
        System.out.println("User added");
    }


    @PutMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void updateUser(){
        System.out.println("User Updated");
    }


    @DeleteMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteUser(){
        System.out.println("User Deleted");
    }
}
