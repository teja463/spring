package com.example.springbootunittesting.springdeveloper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void repoTest() {
        Reservation r = new Reservation(null, "Liyansh");
        reservationRepository.save(r);
        List<Reservation> liyansh = reservationRepository.findByName("Liyansh");
        assertEquals("Liyansh", liyansh.get(0).getName());
        org.assertj.core.api.Assertions.assertThat(liyansh.get(0).getId()).isNotNull();
    }
}
