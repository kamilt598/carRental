package com.example.carrental.controller;

import com.example.carrental.TestSpecification;
import com.example.carrental.model.User;
import org.junit.jupiter.api.Test;

import java.security.Principal;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AccountControllerTest extends TestSpecification {

    @Test
    void getAccount() throws Exception {
        mockMvc.perform(get("/my-account")
                        .principal(mockPrincipal()))
                .andExpect(status().isOk());
    }

    @Test
    void editAccount() throws Exception {
        mockMvc.perform(get("/edit-account")
                        .principal(mockPrincipal()))
                .andExpect(status().isOk());
    }

    @Test
    void saveAccount() throws Exception {
        mockMvc.perform(post("/edit-account")
                        .principal(mockPrincipal())
                        .param("nick", "Nick")
                        .param("password", "pass")
                        .param("email", "test@test.com")
                        .param("phoneNumber", "111222333")
                        .param("firstName", "John"))
                .andExpect(status().is3xxRedirection());
        final Optional<User> client = userRepository.findByNick("Nick");
        assertTrue(client.isPresent());
        assertEquals("test@test.com", client.get().getEmail());
        assertEquals("111222333", client.get().getPhoneNumber());
        assertEquals("John", client.get().getFirstName());
    }

    @Test
    void throwExceptionWhenSaveAccountIfNickExists() throws Exception {
        mockMvc.perform(post("/edit-account")
                        .principal(mockPrincipal())
                        .param("nick", "nick")
                        .param("password", "pass")
                        .param("email", "test@test.com")
                        .param("phoneNumber", "111222333")
                        .param("firstName", "John"))
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "The nickname already exists"))
                .andExpect(redirectedUrl("/edit-account"));
    }

    @Test
    void throwExceptionWhenSaveAccountIfPhoneNumberIsTaken() throws Exception {
        mockMvc.perform(post("/edit-account")
                        .principal(mockPrincipal())
                        .param("nick", "test")
                        .param("password", "pass")
                        .param("email", "test@test.com")
                        .param("phoneNumber", "111111111")
                        .param("firstName", "John"))
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "The phone number is taken by another user"))
                .andExpect(redirectedUrl("/edit-account"));
    }

    @Test
    void throwExceptionWhenSaveAccountIfEmailIsTaken() throws Exception {
        mockMvc.perform(post("/edit-account")
                        .principal(mockPrincipal())
                        .param("nick", "test")
                        .param("password", "pass")
                        .param("email", "email@email.com")
                        .param("phoneNumber", "111222333")
                        .param("firstName", "John"))
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "The e-mail is taken by another user"))
                .andExpect(redirectedUrl("/edit-account"));
    }

    @Test
    void deleteAccount() throws Exception {
        mockMvc.perform(post("/my-account")
                        .principal(mockPrincipal()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/logout"));
        assertEquals(Collections.emptyList(), rentalRepository.findByUserIdNick("test"));
        assertEquals(Optional.empty(), userRepository.findByNick("test"));
    }

    private Principal mockPrincipal() {
        final Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("test");
        return principal;
    }
}