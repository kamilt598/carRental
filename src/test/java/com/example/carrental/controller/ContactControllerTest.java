package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class ContactControllerTest extends TestSpecification {

    @Test
    void getContactView() throws Exception {
        mockMvc.perform(get(endpoints.getContact()))
                .andExpect(view().name("contact"))
                .andExpect(status().isOk());
    }
}