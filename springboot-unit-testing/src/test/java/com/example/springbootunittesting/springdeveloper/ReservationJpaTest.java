package com.example.springbootunittesting.springdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReservationJpaTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void saveReservation(){
        Reservation r = new Reservation(null, "Liyansh");
        Reservation reservation = testEntityManager.persistFlushFind(r);
        assertEquals(reservation.getName(), "Liyansh");
        assertNotNull(reservation.getId());
    }
}