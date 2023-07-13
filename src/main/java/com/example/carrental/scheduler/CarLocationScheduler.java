package com.example.carrental.scheduler;

import com.example.carrental.model.Cars;
import com.example.carrental.model.Rentals;
import com.example.carrental.repository.CarsRepository;
import com.example.carrental.repository.RentalsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CarLocationScheduler {

    private final RentalsRepository rentalsRepository;
    private final CarsRepository carsRepository;

    @Scheduled(cron = "${schedule.car.location}")
    public void schedule() {
        log.info("Car Location Scheduler started");
        final List<Rentals> rentalsList = rentalsRepository.findByEndDate(LocalDate.now(ZoneOffset.UTC).minusDays(1L));
        rentalsList.forEach(rental -> {
            final Cars car = rental.getCarId();
            final String previousPlace = car.getPlace().getCity();
            car.setPlace(rental.getDropOffCity());
            carsRepository.save(car);
            log.info("Successfully changed car {} location from {} to {}", car.getId(), previousPlace, rental.getDropOffCity().getCity());
        });
    }
}
