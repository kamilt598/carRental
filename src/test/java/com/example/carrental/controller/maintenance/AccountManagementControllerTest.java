package com.example.carrental.controller.maintenance;

import com.example.carrental.TestSpecification;
import com.example.carrental.mapper.UserMapper;
import com.example.carrental.model.User;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AccountManagementControllerTest extends TestSpecification {

    @Test
    void getAccountManagement() throws Exception {
        mockMvc.perform(get(endpoints.getAccountManagement()))
                .andExpect(model().attribute("userList", userRepository.findAll().stream().map(UserMapper::mapToDto).toList()))
                .andExpect(view().name("admin/accountManagement"))
                .andExpect(status().isOk());
    }

    @Test
    void editAccount() throws Exception {
        mockMvc.perform(get(endpoints.getEditAccountByAdmin(), user.getNick()))
                .andExpect(model().attribute("user", UserMapper.mapToDto(user)))
                .andExpect(view().name("admin/editAccountByAdmin"))
                .andExpect(status().isOk());
    }

    @Test
    void saveAccount() throws Exception {
        mockMvc.perform(post(endpoints.getEditAccountByAdmin(), user.getNick())
                        .param("nick", "Nick")
                        .param("password", "pass")
                        .param("email", "test@test.com")
                        .param("phoneNumber", "111222333")
                        .param("firstName", "John"))
                .andExpect(redirectedUrl(endpoints.getAccountManagement()))
                .andExpect(status().is3xxRedirection());
        final Optional<User> client = userRepository.findByNick("Nick");
        assertTrue(client.isPresent());
        assertEquals("test@test.com", client.get().getEmail());
        assertEquals("111222333", client.get().getPhoneNumber());
        assertEquals("John", client.get().getFirstName());
    }

    @Test
    void deleteAccount() throws Exception {
        final String nick = user.getNick();
        mockMvc.perform(get(endpoints.getDeleteAccount(), nick))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(endpoints.getAccountManagement()));
        assertEquals(Collections.emptyList(), rentalRepository.findByNick(nick));
        assertEquals(Optional.empty(), userRepository.findByNick(nick));
    }
}