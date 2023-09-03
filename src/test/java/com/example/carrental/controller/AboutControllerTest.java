package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class AboutControllerTest extends TestSpecification {

    @Test
    void getAboutView() throws Exception {
        mockMvc.perform(get(endpoints.getAbout()))
                .andExpect(view().name("about"))
                .andExpect(status().isOk());
    }
}