package com.example.carrental;

import com.example.carrental.dto.CarDto;
import com.example.carrental.getter.CarGetter;
import com.example.carrental.getter.PlaceGetter;
import com.example.carrental.model.Clients;
import com.example.carrental.model.Places;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestSpecification {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    protected RentalsRepository rentalsRepository;
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
                .build();
        when(rentalsRepository.save(any(Rentals.class)))
                .thenReturn(Rentals.builder()
                        .id(1L)
                        .build());
        when(rentalsRepository.findByClientIdNick(anyString()))
                .thenReturn(List.of(Rentals.builder()
                        .id(1L)
                        .build()));
        when(rentalsRepository.findInDateRange(any(), any()))
                .thenReturn(Collections.emptyList());
        doNothing().when(rentalsRepository).deleteById(any());
        when(carGetter.getCars())
                .thenReturn(List.of(CarDto.builder()
                        .id(1L)
                        .build()));
        when(carGetter.getCarsWithoutIds(any()))
                .thenReturn(List.of(CarDto.builder()
                        .id(1L)
                        .build()));
        when(placeGetter.getPlacesWithout(any()))
                .thenReturn(List.of(Places.builder()
                        .id(1L)
                        .city("City")
                        .build()));
        when(placeGetter.getPlaces())
                .thenReturn(List.of(Places.builder()
                        .id(1L)
                        .city("City")
                        .build()));
        when(clientsRepository.save(any(Clients.class)))
                .thenReturn(Clients.builder()
                        .id(1L)
                        .build());
    }
}
