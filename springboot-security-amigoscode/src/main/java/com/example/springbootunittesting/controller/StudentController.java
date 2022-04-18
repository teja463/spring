package com.example.springbootunittesting.controller;

import com.example.springbootunittesting.model.Reservation;
import com.example.springbootunittesting.repos.ReservationRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final ReservationRepository reservationRepository;

    public StudentController(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }
}
