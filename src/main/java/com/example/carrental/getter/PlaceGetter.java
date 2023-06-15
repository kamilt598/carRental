package com.example.carrental.getter;

import com.example.carrental.dto.PlaceDto;
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
        return mapToDto(placesRepository.findAll());
    }

    private PlaceDto mapToDto(Places places) {
        return PlaceDto.builder()
                .city(places.getCity())
                .build();
    }

    private List<PlaceDto> mapToDto(List<Places> placesList) {
        return placesList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
