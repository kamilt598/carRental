package com.example.carrental;

import com.example.carrental.config.Endpoints;
import com.example.carrental.getter.CarGetter;
import com.example.carrental.model.Car;
import com.example.carrental.model.User;
import com.example.carrental.model.Place;
import com.example.carrental.model.Rental;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.repository.UserRepository;
import com.example.carrental.repository.PlaceRepository;
import com.example.carrental.repository.RentalRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;

@SpringBootTest
public class TestSpecification {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    protected PlaceRepository placeRepository;
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected CarRepository carRepository;
    @Autowired
    protected RentalRepository rentalRepository;
    @Autowired
    protected Endpoints endpoints;
    @Autowired
    protected CarGetter carGetter;
    protected MockMvc mockMvc;
    protected Rental rental;
    protected Car car;
    protected Car car2;
    protected Place place1;
    protected Place place2;
    protected User user;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        place1 = placeRepository.save(Place.builder()
                .city("Rzeszow")
                .build());
        place2 = placeRepository.save(Place.builder()
                .city("Krakow")
                .build());
        car = carRepository.save(Car.builder()
                .place(place1)
                .price(BigDecimal.ONE)
                .build());
        car2 = carRepository.save(Car.builder()
                .place(place2)
                .price(BigDecimal.ONE)
                .build());
        user = userRepository.save(User.builder()
                .nick("test")
                .password("test")
                .role("ROLE_USER")
                .build());
        userRepository.save(User.builder()
                .nick("nick")
                .password("test")
                .role("ROLE_USER")
                .phoneNumber("111111111")
                .email("email@email.com")
                .build());
        rental = rentalRepository.save(Rental.builder()
                .carId(car)
                .pickUpCity(place1)
                .dropOffCity(place2)
                .startDate(LocalDate.now(ZoneOffset.UTC).minusDays(5L))
                .endDate(LocalDate.now(ZoneOffset.UTC).minusDays(1L))
                .userId(user)
                .build());
    }

    @AfterEach
    public void cleanup() {
        rentalRepository.deleteAll();
        userRepository.deleteAll();
        carRepository.deleteAll();
        placeRepository.deleteAll();
    }
}
