package com.example.carrental.service.impl;

import com.example.carrental.exception.CustomException;
import com.example.carrental.model.Place;
import com.example.carrental.repository.PlaceRepository;
import com.example.carrental.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;
    @Value("${car-rental.endpoint.placeManagement}")
    private String placeManagement;

    @Override
    public String getPlacesMaintenanceView(Model model) {
        model.addAttribute("placeList", placeRepository.findAll(Sort.by("city")));
        return "admin/placeManagement";
    }

    @Override
    public RedirectView createPlace(String city) {
        try {
            placeRepository.save(Place.builder()
                    .city(city)
                    .build());
            return new RedirectView(placeManagement);
        } catch (Exception e) {
            throw new CustomException(Map.of("error", e.getMessage()), placeManagement);
        }
    }

    @Override
    public RedirectView deletePlace(String city) {
        try {
            final Place place = placeRepository.findByCity(city).orElseThrow();
            placeRepository.delete(place);
            return new RedirectView(placeManagement);
        } catch (Exception e) {
            throw new CustomException(Map.of("error", e.getMessage()), placeManagement);
        }
    }
}
