package com.example.carrental.controller.maintenance;

import com.example.carrental.TestSpecification;
import com.example.carrental.model.Car;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CarManagementControllerTest extends TestSpecification {

    @Test
    void getCarManagement() throws Exception {
        mockMvc.perform(get(endpoints.getCarManagement()))
                .andExpect(model().attribute("cars", carGetter.getCars()))
                .andExpect(view().name("admin/carManagement"))
                .andExpect(status().isOk());
    }

    @Test
    void createCar() throws Exception {
        mockMvc.perform(post(endpoints.getCarManagement())
                        .param("brand", "test")
                        .param("model", "test")
                        .param("type", "test")
                        .param("productionYear", "2000")
                        .param("engine", "test")
                        .param("color", "test")
                        .param("picture", "test")
                        .param("price", "500")
                        .param("city", place1.getCity()))
                .andExpect(redirectedUrl(endpoints.getCarManagement()))
                .andExpect(status().is3xxRedirection());
        final List<Car> newCar = carRepository.findAll()
                .stream()
                .filter(c -> Objects.equals(c.getBrand(), "test"))
                .toList();
        assertEquals(1, newCar.size());
        assertEquals("test", newCar.get(0).getBrand());
        assertEquals("test", newCar.get(0).getModel());
        assertEquals("test", newCar.get(0).getType());
        assertEquals("test", newCar.get(0).getBrand());
        assertEquals("2000", newCar.get(0).getProductionYear());
        assertEquals("test", newCar.get(0).getEngine());
        assertEquals("test", newCar.get(0).getColor());
        assertEquals("test", newCar.get(0).getPicture());
        assertEquals(new BigDecimal(500).setScale(2, RoundingMode.HALF_UP), newCar.get(0).getPrice());
        assertEquals(place1.getCity(), newCar.get(0).getPlace().getCity());
    }

    @Test
    void throwExceptionWhenCreateCar() throws Exception {
        mockMvc.perform(post(endpoints.getCarManagement())
                        .param("brand", "test")
                        .param("model", "test")
                        .param("type", "test")
                        .param("productionYear", "2000")
                        .param("engine", "test")
                        .param("color", "test")
                        .param("picture", "test")
                        .param("price", "500")
                        .param("city", "test"))
                .andExpect(redirectedUrl(endpoints.getCarManagement()))
                .andExpect(flash().attribute("error", "No value present"))
                .andExpect(status().is3xxRedirection());
        final List<Car> newCar = carRepository.findAll()
                .stream()
                .filter(c -> Objects.equals(c.getBrand(), "test"))
                .toList();
        assertEquals(Collections.emptyList(), newCar);
    }

    @Test
    void deleteCar() throws Exception {
        rentalRepository.deleteAll();
        mockMvc.perform(get(endpoints.getDeleteCar(), car.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(endpoints.getCarManagement()));
        assertEquals(Optional.empty(), carRepository.findById(car.getId()));
    }

    @Test
    void throwExceptionWhenDeleteCar() throws Exception {
        mockMvc.perform(get(endpoints.getDeleteCar(), 999))
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "No value present"))
                .andExpect(redirectedUrl(endpoints.getCarManagement()));
    }

    @Test
    void editCar() throws Exception {
        mockMvc.perform(get(endpoints.getEditCar(), car.getId()))
                .andExpect(model().attribute("car", carGetter.getCarById(car.getId())))
                .andExpect(view().name("admin/editCar"))
                .andExpect(status().isOk());
    }

    @Test
    void throwExceptionWhenEditCar() throws Exception {
        mockMvc.perform(get(endpoints.getEditCar(), 999))
                .andExpect(status().is3xxRedirection())
                .andExpect(flash().attribute("error", "No value present"))
                .andExpect(redirectedUrl(endpoints.getCarManagement()));
    }

    @Test
    void saveCar() throws Exception {
        mockMvc.perform(post(endpoints.getEditCar(), car.getId())
                        .param("brand", "test")
                        .param("model", "test")
                        .param("type", "test")
                        .param("productionYear", "2000")
                        .param("engine", "test")
                        .param("color", "test")
                        .param("picture", "test")
                        .param("price", "500")
                        .param("location", place2.getCity()))
                .andExpect(redirectedUrl(endpoints.getCarManagement()))
                .andExpect(status().is3xxRedirection());
        final Optional<Car> editedCar = carRepository.findById(car.getId());
        assertTrue(editedCar.isPresent());
        assertEquals("test", editedCar.get().getBrand());
        assertEquals("test", editedCar.get().getModel());
        assertEquals("test", editedCar.get().getType());
        assertEquals("test", editedCar.get().getBrand());
        assertEquals("2000", editedCar.get().getProductionYear());
        assertEquals("test", editedCar.get().getEngine());
        assertEquals("test", editedCar.get().getColor());
        assertEquals("test", editedCar.get().getPicture());
        assertEquals(new BigDecimal(500).setScale(2, RoundingMode.HALF_UP), editedCar.get().getPrice());
        assertEquals(place2.getCity(), editedCar.get().getPlace().getCity());
    }

    @Test
    void throwExceptionWhenSaveCar() throws Exception {
        mockMvc.perform(post(endpoints.getEditCar(), 999)
                        .param("brand", "test")
                        .param("model", "test")
                        .param("type", "test")
                        .param("productionYear", "2000")
                        .param("engine", "test")
                        .param("color", "test")
                        .param("picture", "test")
                        .param("price", "500")
                        .param("location", place2.getCity()))
                .andExpect(redirectedUrl(endpoints.getCarManagement()))
                .andExpect(flash().attribute("error", "No value present"))
                .andExpect(status().is3xxRedirection());
        final Optional<Car> editedCar = carRepository.findById(car.getId());
        assertTrue(editedCar.isPresent());
        assertNotEquals("test", editedCar.get().getBrand());
        assertNotEquals("test", editedCar.get().getModel());
        assertNotEquals("test", editedCar.get().getType());
        assertNotEquals("test", editedCar.get().getBrand());
        assertNotEquals("2000", editedCar.get().getProductionYear());
        assertNotEquals("test", editedCar.get().getEngine());
        assertNotEquals("test", editedCar.get().getColor());
        assertNotEquals("test", editedCar.get().getPicture());
        assertNotEquals(new BigDecimal(500).setScale(2, RoundingMode.HALF_UP), editedCar.get().getPrice());
        assertNotEquals(place2.getCity(), editedCar.get().getPlace().getCity());
    }
}