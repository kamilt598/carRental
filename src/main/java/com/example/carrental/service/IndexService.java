package com.example.carrental.service;

import com.example.carrental.dto.CarDto;
import com.example.carrental.getter.CarGetter;
import com.example.carrental.getter.ClientGetter;
import com.example.carrental.getter.PlaceGetter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IndexService {
    private final CarGetter carGetter;
    private final PlaceGetter placeGetter;
    private final ClientGetter clientGetter;

    public String getIndex(Model model) {
        final List<CarDto> carsList = carGetter.getCars();
        final List<CarDto> carsFiltered = carsList.stream()
                .filter(cars -> !cars.getIsRented())
                .toList();
        model.addAttribute("carsList", carsList);
        model.addAttribute("placesList", placeGetter.getPlaces());
        model.addAttribute("clientsList", clientGetter.getClients());
        model.addAttribute("carsFiltered", carsFiltered);
        return "./index";
    }
}
