package com.example.carrental;

import com.example.carrental.model.Cars;
import com.example.carrental.model.Clients;
import com.example.carrental.model.Places;
import com.example.carrental.model.Rentals;
import com.example.carrental.repository.CarsRepository;
import com.example.carrental.repository.ClientsRepository;
import com.example.carrental.repository.PlacesRepository;
import com.example.carrental.repository.RentalsRepository;
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
    private PlacesRepository placesRepository;
    @Autowired
    protected ClientsRepository clientsRepository;
    @Autowired
    protected CarsRepository carsRepository;
    @Autowired
    protected RentalsRepository rentalsRepository;
    protected MockMvc mockMvc;
    protected Rentals rental;
    protected Cars car;
    protected Cars car2;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        final Places place1 = placesRepository.save(Places.builder()
                .city("Rzeszow")
                .build());
        final Places place2 = placesRepository.save(Places.builder()
                .city("Krakow")
                .build());
        car = carsRepository.save(Cars.builder()
                .place(place1)
                .price(BigDecimal.ONE)
                .build());
        car2 = carsRepository.save(Cars.builder()
                .place(place2)
                .price(BigDecimal.ONE)
                .build());
        final Clients client = clientsRepository.save(Clients.builder()
                .nick("test")
                .password("test")
                .roles("ROLE_USER")
                .build());
        clientsRepository.save(Clients.builder()
                .nick("nick")
                .password("test")
                .roles("ROLE_USER")
                .phoneNumber("111111111")
                .email("email@email.com")
                .build());
        rental = rentalsRepository.save(Rentals.builder()
                .carId(car)
                .pickUpCity(place1)
                .dropOffCity(place2)
                .startDate(LocalDate.now(ZoneOffset.UTC).minusDays(5L))
                .endDate(LocalDate.now(ZoneOffset.UTC).minusDays(1L))
                .clientId(client)
                .build());
    }

    @AfterEach
    public void cleanup() {
        rentalsRepository.deleteAll();
        clientsRepository.deleteAll();
        carsRepository.deleteAll();
        placesRepository.deleteAll();
    }
}
