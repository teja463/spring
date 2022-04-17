package com.example.springbootunittesting;

import com.example.springbootunittesting.springdeveloper.Reservation;
import com.example.springbootunittesting.springdeveloper.ReservationRepository;
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
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }
}
