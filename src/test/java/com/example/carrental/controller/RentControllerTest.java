package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import java.security.Principal;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RentControllerTest extends TestSpecification {

    @Test
    @WithMockUser("principal")
    void createRental() throws Exception {
        Principal principal = mock(Principal.class);
        mockMvc.perform(post("/car-selection")
                        .param("pickUpCity", "Rzeszow")
                        .param("dropOffCity", "Krakow")
                        .param("startDate", "2023-01-01")
                        .param("endDate", "2023-01-02")
                        .param("carId", "1")
                        .principal(principal))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/myRentals"));
    }

    @Test
    void selectCars() throws Exception {
        mockMvc.perform(post("/car-selection")
                        .param("pickUpCity", "Rzeszow")
                        .param("dropOffCity", "Krakow")
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
    @WithMockUser("principal")
    void getRentals() throws Exception {
        Principal principal = mock(Principal.class);
        mockMvc.perform(get("/myRentals")
                        .principal(principal))
                .andExpect(status().isOk())
                .andExpect(model().attribute("rentalsList", hasSize(notNullValue())));
    }

    @Test
    @WithMockUser("principal")
    void cancelRental() throws Exception {
        Principal principal = mock(Principal.class);
        mockMvc.perform(post("/myRentals")
                        .param("rentalId", "1")
                        .principal(principal))
                .andExpect(status().isOk())
                .andExpect(model().attribute("rentalsList", hasSize(notNullValue())));
    }
}