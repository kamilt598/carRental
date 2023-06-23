package com.example.carrental;

import com.example.carrental.dto.CarDto;
import com.example.carrental.dto.PlaceDto;
import com.example.carrental.getter.CarGetter;
import com.example.carrental.getter.PlaceGetter;
import com.example.carrental.model.Clients;
import com.example.carrental.model.Rentals;
import com.example.carrental.repository.ClientsRepository;
import com.example.carrental.repository.RentalsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
public class TestSpecification {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private RentalsRepository rentalsRepository;
    @MockBean
    private CarGetter carGetter;
    @MockBean
    private PlaceGetter placeGetter;
    @MockBean
    private ClientsRepository clientsRepository;
    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
        when(rentalsRepository.save(any(Rentals.class)))
                .thenReturn(Rentals.builder()
                        .id(1L)
                        .build());
        when(rentalsRepository.findByClientId_Nick(anyString()))
                .thenReturn(List.of(Rentals.builder()
                        .id(1L)
                        .build()));
        when(rentalsRepository.findInDateRange(any(), any()))
                .thenReturn(Collections.emptyList());
        when(carGetter.getCars())
                .thenReturn(List.of(CarDto.builder()
                        .id(1L)
                        .build()));
        when(carGetter.getCarsWithoutIds(any()))
                .thenReturn(List.of(CarDto.builder()
                        .id(1L)
                        .build()));
        when(placeGetter.getPlacesWithout(any()))
                .thenReturn(List.of(PlaceDto.builder()
                        .city("City")
                        .build()));
        when(placeGetter.getPlaces())
                .thenReturn(List.of(PlaceDto.builder()
                        .city("City")
                        .build()));
        when(clientsRepository.save(any(Clients.class)))
                .thenReturn(Clients.builder()
                        .id(1L)
                        .build());
    }
}
