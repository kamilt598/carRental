package com.example.carrental.controller.maintenance;

import com.example.carrental.TestSpecification;
import com.example.carrental.model.Place;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PlaceManagementControllerTest extends TestSpecification {

    @Test
    void getPlaceManagement() throws Exception {
        mockMvc.perform(get(endpoints.getPlaceManagement()))
                .andExpect(view().name("admin/placeManagement"))
                .andExpect(model().attribute("placeList", placeRepository.findAll(Sort.by("city"))))
                .andExpect(status().isOk());
    }

    @Test
    void createPlace() throws Exception {
        mockMvc.perform(post(endpoints.getPlaceManagement())
                        .param("newCity", "test"))
                .andExpect(redirectedUrl(endpoints.getPlaceManagement()))
                .andExpect(status().is3xxRedirection());
        final Optional<Place> place = placeRepository.findByCity("test");
        assertTrue(place.isPresent());
        assertEquals("test", place.get().getCity());
    }

    @Test
    void throwExceptionWhenCreatePlace() throws Exception {
        mockMvc.perform(post(endpoints.getPlaceManagement())
                        .param("newCity", place1.getCity()))
                .andExpect(redirectedUrl(endpoints.getPlaceManagement()))
                .andExpect(flash().attributeExists("error"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void deletePlace() throws Exception {
        rentalRepository.deleteAll();
        carRepository.deleteAll();
        mockMvc.perform(get(endpoints.getDeletePlace(), place1.getCity()))
                .andExpect(redirectedUrl(endpoints.getPlaceManagement()))
                .andExpect(status().is3xxRedirection());
        final Optional<Place> place = placeRepository.findByCity(place1.getCity());
        assertFalse(place.isPresent());
    }

    @Test
    void throwExceptionWhenDeletePlace() throws Exception {
        mockMvc.perform(get(endpoints.getDeletePlace(), "test"))
                .andExpect(redirectedUrl(endpoints.getPlaceManagement()))
                .andExpect(flash().attributeExists("error"))
                .andExpect(status().is3xxRedirection());
    }
}