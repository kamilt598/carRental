package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;

class RegisterControllerTest extends TestSpecification {

    @Test
    void getRegisterView() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
    }

    @Test
    void registerUser() throws Exception {
        mockMvc.perform(post("/register")
                        .param("nick", "Nick")
                        .param("password", "pass")
                        .param("email", "test@test.com")
                        .param("firstName", "John"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }
}