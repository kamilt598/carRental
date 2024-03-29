package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class LoginControllerTest extends TestSpecification {

    @Test
    void getLoginView() throws Exception {
        mockMvc.perform(get(endpoints.getLogin()))
                .andExpect(view().name("auth/login"))
                .andExpect(status().isOk());
    }
}