package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class HomeControllerTest extends TestSpecification {
    @Test
    void getIndex() throws Exception {
        mockMvc.perform(get(endpoints.getHome()))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("placesList", placeRepository.findAll()));
    }
}