package com.example.springbootunittesting.springdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ReservationRepository reservationRepository;

    @Test
    public void getReservations() throws Exception {
        when(reservationRepository.findAll()).thenReturn(Collections.singletonList(new Reservation(1L, "Teja")));
        mockMvc.perform(MockMvcRequestBuilders.get("/reservations"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").isNumber());
    }
}
