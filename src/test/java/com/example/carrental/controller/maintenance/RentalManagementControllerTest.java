package com.example.carrental.controller.maintenance;

import com.example.carrental.TestSpecification;
import com.example.carrental.model.Rental;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RentalManagementControllerTest extends TestSpecification {

    @Test
    void getRentalManagement() throws Exception {
        mockMvc.perform(get(endpoints.getRentalManagement()))
                .andExpect(view().name("admin/rentalManagement"))
                .andExpect(model().attribute("rentalsList", hasSize(notNullValue())))
                .andExpect(status().isOk());
    }

    @Test
    void cancelRental() throws Exception {
        mockMvc.perform(post(endpoints.getRentalManagement())
                        .param("rentalId", rental.getId().toString()))
                .andExpect(view().name("admin/rentalManagement"))
                .andExpect(model().attribute("rentalsList", Collections.emptyList()))
                .andExpect(status().isOk());
        final Optional<Rental> rentalOptional = rentalRepository.findById(rental.getId());
        assertFalse(rentalOptional.isPresent());
    }
}