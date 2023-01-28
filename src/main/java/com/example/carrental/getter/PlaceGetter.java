package com.example.carrental.getter;

import com.example.carrental.dto.CarDto;
import com.example.carrental.dto.PlaceDto;
import com.example.carrental.model.Cars;
import com.example.carrental.model.Places;
import com.example.carrental.repository.PlacesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PlaceGetter {

    private final PlacesRepository placesRepository;

    public List<PlaceDto> getPlaces() {
        return entityToDTO(placesRepository.findAll());
    }

    public static PlaceDto entityToDTO(Places places) {
        return PlaceDto.builder()
                .city(places.getCity())
                .build();
    }

    public static List<PlaceDto> entityToDTO(List<Places> placesList) {
        return placesList.stream()
                .map(PlaceGetter::entityToDTO)
                .collect(Collectors.toList());
    }

    public static Places DTOToEntity(PlaceDto placeDto) {
        return Places.builder()
                .city(placeDto.getCity())
                .build();
    }

    public static List<Places> DTOToEntity(List<PlaceDto> placeDtos) {
        return placeDtos.stream()
                .map(PlaceGetter::DTOToEntity)
                .collect(Collectors.toList());
    }
}
