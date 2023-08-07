package com.example.carrental.scheduler;

import com.example.carrental.TestSpecification;
import com.example.carrental.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarLocationSchedulerTest extends TestSpecification {

    @Autowired
    private CarLocationScheduler carLocationScheduler;


    @Test
    void schedule() {
        carLocationScheduler.schedule();
        final Optional<Car> carsOptional = carRepository.findById(car.getId());
        assertTrue(carsOptional.isPresent());
        assertEquals(carsOptional.get().getPlace().getCity(), "Krakow");
    }
}