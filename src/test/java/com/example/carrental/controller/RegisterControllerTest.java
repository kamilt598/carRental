package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    void throwExceptionWhenRegisterIfNickExists() throws Exception {
        mockMvc.perform(post("/register")
                        .param("nick", "nick")
                        .param("password", "pass")
                        .param("email", "test@test.com")
                        .param("firstName", "John"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/register"))
                .andExpect(flash().attribute("error", "The nickname already exists"));
    }

    @Test
    void throwExceptionWhenRegisterIfPhoneNumberIsTaken() throws Exception {
        mockMvc.perform(post("/register")
                        .param("nick", "Nick")
                        .param("password", "pass")
                        .param("email", "test@test.com")
                        .param("phoneNumber", "111111111")
                        .param("firstName", "John"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/register"))
                .andExpect(flash().attribute("error", "The phone number is taken by another user"));
    }

    @Test
    void throwExceptionWhenRegisterIfEmailIsTaken() throws Exception {
        mockMvc.perform(post("/register")
                        .param("nick", "Nick")
                        .param("password", "pass")
                        .param("email", "email@email.com")
                        .param("firstName", "John"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/register"))
                .andExpect(flash().attribute("error", "The e-mail is taken by another user"));
    }
}