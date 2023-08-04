package com.teja.springboot.security.repos;

import com.teja.springboot.security.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findByName(String name);
}
