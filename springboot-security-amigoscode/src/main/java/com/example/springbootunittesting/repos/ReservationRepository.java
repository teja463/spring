package com.example.springbootunittesting.repos;

import com.example.springbootunittesting.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findByName(String name);
}
