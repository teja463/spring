package com.example.springbootunittesting.controller;

import com.example.springbootunittesting.model.Reservation;
import com.example.springbootunittesting.repos.ReservationRepository;
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
    public void addUser(){
        System.out.println("User added");
    }


    @PutMapping
    public void updateUser(){
        System.out.println("User Updated");
    }


    @DeleteMapping
    public void deleteUser(){
        System.out.println("User Deleted");
    }
}
