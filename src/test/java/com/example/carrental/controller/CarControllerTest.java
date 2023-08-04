package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import com.example.carrental.model.Rentals;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
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
    void selectCarsWithRentedCarsIds() throws Exception {
        rentalsRepository.save(Rentals.builder()
                .carId(car2)
                .startDate(LocalDate.of(2023, 1, 1))
                .endDate(LocalDate.of(2023, 1, 2))
                .build());
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

    @Test
    void getCarSelection() throws Exception {
        mockMvc.perform(get("/car-selection"))
                .andExpect(status().isOk());
    }

    @Test
    void getCarDetails() throws Exception {
        mockMvc.perform(get("/car-details/" + car.getId()))
                .andExpect(status().isOk());
    }
}