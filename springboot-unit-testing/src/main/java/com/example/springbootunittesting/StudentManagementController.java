package com.example.springbootunittesting;

import com.example.springbootunittesting.springdeveloper.Reservation;
import com.example.springbootunittesting.springdeveloper.ReservationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="student-controller", description = "Controller to update student Info")
@RestController
@RequestMapping("/mgmt/students")
public class StudentManagementController {

    private final ReservationRepository reservationRepository;

    public StudentManagementController(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }


    @Operation(summary = "foo", description = "bar")
    @GetMapping
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    @PostMapping
    public Reservation addUser(Reservation input){
        System.out.println("User added");
        return new Reservation();
    }


    @PutMapping
    public Reservation updateUser(Reservation res){
        System.out.println("User Updated");
        return new Reservation();
    }


    @DeleteMapping("/id/{id}")
    public void deleteUser(int id){
        System.out.println("User Deleted");
    }
}
