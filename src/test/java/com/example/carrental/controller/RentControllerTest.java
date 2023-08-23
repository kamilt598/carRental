package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;

import java.security.Principal;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RentControllerTest extends TestSpecification {

    @Test
    void createRental() throws Exception {
        Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("test");
        mockMvc.perform(post("/car-selection")
                        .param("pickUpCity.id", place1.getId().toString())
                        .param("pickUpCity.city", place1.getCity())
                        .param("dropOffCity.id", place2.getId().toString())
                        .param("dropOffCity.city", place2.getCity())
                        .param("startDate", "2023-01-01")
                        .param("endDate", "2023-01-02")
                        .param("carId", car.getId().toString())
                        .principal(principal))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/my-rentals"));
    }

    @Test
    void selectCars() throws Exception {
        mockMvc.perform(post("/car-selection")
                        .param("pickUpCity.id", place1.getId().toString())
                        .param("pickUpCity.city", place1.getCity())
                        .param("dropOffCity.id", place2.getId().toString())
                        .param("dropOffCity.city", place2.getCity())
                        .param("startDate", "2023-01-01")
                        .param("endDate", "2023-01-02"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/car-selection"))
                .andExpect(flash().attribute("cars", hasSize(notNullValue())))
                .andExpect(flash().attribute("rental", notNullValue()))
                .andExpect(flash().attribute("pickUpCities", hasSize(notNullValue())))
                .andExpect(flash().attribute("dropOffCities", hasSize(notNullValue())));
    }

    @Test
    void getRentals() throws Exception {
        Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("test");
        mockMvc.perform(get("/my-rentals")
                        .principal(principal))
                .andExpect(status().isOk())
                .andExpect(model().attribute("rentalsList", hasSize(notNullValue())));
    }

    @Test
    void cancelRental() throws Exception {
        Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("test");
        mockMvc.perform(post("/my-rentals")
                        .param("rentalId", rental.getId().toString())
                        .principal(principal))
                .andExpect(status().isOk())
                .andExpect(model().attribute("rentalsList", hasSize(notNullValue())));
    }
}