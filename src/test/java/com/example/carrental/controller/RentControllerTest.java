package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import com.example.carrental.model.Rental;
import org.junit.jupiter.api.Test;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RentControllerTest extends TestSpecification {

    @Test
    void createRental() throws Exception {
        rentalRepository.deleteAll();
        Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("test");
        mockMvc.perform(post(endpoints.getCarSelection())
                        .param("pickUpCity.id", place1.getId().toString())
                        .param("pickUpCity.city", place1.getCity())
                        .param("dropOffCity.id", place2.getId().toString())
                        .param("dropOffCity.city", place2.getCity())
                        .param("startDate", "2023-01-01")
                        .param("endDate", "2023-01-02")
                        .param("carId", car.getId().toString())
                        .principal(principal))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(endpoints.getMyRentals()));
        final List<Rental> rentals = rentalRepository.findAll();
        assertEquals(1, rentals.size());
        assertEquals(place1.getCity(), rentals.get(0).getPickUpCity().getCity());
        assertEquals(place2.getCity(), rentals.get(0).getDropOffCity().getCity());
        assertEquals(LocalDate.of(2023, 1, 1), rentals.get(0).getStartDate());
        assertEquals(LocalDate.of(2023, 1, 2), rentals.get(0).getEndDate());
        assertEquals(car.getId(), rentals.get(0).getCarId().getId());
        assertEquals(user.getId(), rentals.get(0).getUserId().getId());
    }

    @Test
    void selectCars() throws Exception {
        mockMvc.perform(post(endpoints.getCarSelection())
                        .param("pickUpCity.id", place1.getId().toString())
                        .param("pickUpCity.city", place1.getCity())
                        .param("dropOffCity.id", place2.getId().toString())
                        .param("dropOffCity.city", place2.getCity())
                        .param("startDate", "2023-01-01")
                        .param("endDate", "2023-01-02"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(endpoints.getCarSelection()))
                .andExpect(flash().attribute("cars", hasSize(notNullValue())))
                .andExpect(flash().attribute("rental", notNullValue()))
                .andExpect(flash().attribute("pickUpCities", hasSize(notNullValue())))
                .andExpect(flash().attribute("dropOffCities", hasSize(notNullValue())));
    }

    @Test
    void getRentals() throws Exception {
        Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("test");
        mockMvc.perform(get(endpoints.getMyRentals())
                        .principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("myRentals"))
                .andExpect(model().attribute("rentalsList", hasSize(notNullValue())));
    }

    @Test
    void cancelRental() throws Exception {
        Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("test");
        mockMvc.perform(post(endpoints.getMyRentals())
                        .param("rentalId", rental.getId().toString())
                        .principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("myRentals"))
                .andExpect(model().attribute("rentalsList", hasSize(notNullValue())));
        assertFalse(rentalRepository.findById(rental.getId()).isPresent());
    }
}