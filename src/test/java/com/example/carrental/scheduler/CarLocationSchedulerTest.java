package com.example.carrental.scheduler;

import com.example.carrental.TestSpecification;
import com.example.carrental.model.Cars;
import com.example.carrental.model.Places;
import com.example.carrental.model.Rentals;
import com.example.carrental.repository.CarsRepository;
import com.example.carrental.repository.PlacesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarLocationSchedulerTest extends TestSpecification {

    @Autowired
    private CarLocationScheduler carLocationScheduler;


    @Test
    void schedule() {
        carLocationScheduler.schedule();
        final Optional<Cars> carsOptional = carsRepository.findById(car.getId());
        assertTrue(carsOptional.isPresent());
        assertEquals(carsOptional.get().getPlace().getCity(), "Krakow");
    }
}