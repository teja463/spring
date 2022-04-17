package com.example.springbootunittesting;

import com.example.springbootunittesting.springdeveloper.Reservation;
import com.example.springbootunittesting.springdeveloper.ReservationRepository;
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
