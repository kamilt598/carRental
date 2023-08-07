package com.example.carrental.scheduler;

import com.example.carrental.model.Car;
import com.example.carrental.model.Rental;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.repository.RentalRepository;
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

    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;

    @Scheduled(cron = "${schedule.car.location}")
    public void schedule() {
        log.info("Car Location Scheduler started");
        final List<Rental> rentalList = rentalRepository.findByEndDate(LocalDate.now(ZoneOffset.UTC).minusDays(1L));
        rentalList.forEach(rental -> {
            final Car car = rental.getCarId();
            final String previousPlace = car.getPlace().getCity();
            car.setPlace(rental.getDropOffCity());
            carRepository.save(car);
            log.info("Successfully changed car {} location from {} to {}", car.getId(), previousPlace, rental.getDropOffCity().getCity());
        });
    }
}
