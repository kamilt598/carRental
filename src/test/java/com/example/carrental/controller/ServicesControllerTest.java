package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class ServicesControllerTest extends TestSpecification {

    @Test
    void getServicesView() throws Exception {
        mockMvc.perform(get(endpoints.getServices()))
                .andExpect(view().name("services"))
                .andExpect(status().isOk());
    }
}