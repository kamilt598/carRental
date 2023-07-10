package com.example.carrental.getter;

import com.example.carrental.model.Places;
import com.example.carrental.repository.PlacesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlaceGetter {

    private final PlacesRepository placesRepository;

    public List<Places> getPlaces() {
        return placesRepository.findAll();
    }

    public List<Places> getPlacesWithout(Places place) {
        return placesRepository.findByIdNot(place.getId());
    }
}
