package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import com.example.carrental.model.Cars;
import com.example.carrental.model.Rentals;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CarControllerTest extends TestSpecification {

    @Test
    void selectCars() throws Exception {
        mockMvc.perform(post("/index")
                        .param("pickUpCity", "1", "Rzeszow")
                        .param("dropOffCity", "2", "Krakow")
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
    void selectCarsWhenRentalsExists() throws Exception {
        when(rentalsRepository.findInDateRange(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(List.of(Rentals.builder()
                        .id(1L)
                        .carId(Cars.builder()
                                .id(1L)
                                .build())
                        .build()));
        mockMvc.perform(post("/index")
                        .param("pickUpCity", "1", "Rzeszow")
                        .param("dropOffCity", "2", "Krakow")
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
    void getCars() throws Exception {
        mockMvc.perform(get("/car"))
                .andExpect(status().isOk());
    }
}