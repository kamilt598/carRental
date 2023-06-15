package com.example.carrental.service.impl;

import com.example.carrental.dto.CarDto;
import com.example.carrental.getter.CarGetter;
import com.example.carrental.getter.PlaceGetter;
import com.example.carrental.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IndexServiceImpl implements IndexService {

    private final CarGetter carGetter;
    private final PlaceGetter placeGetter;

    @Override
    public String getIndex(Model model) {
        final List<CarDto> carsList = carGetter.getCars();
        final List<CarDto> carsFiltered = carsList.stream()
                .filter(cars -> !cars.getIsRented())
                .toList();
        model.addAttribute("carsList", carsList);
        model.addAttribute("placesList", placeGetter.getPlaces());
        model.addAttribute("carsFiltered", carsFiltered);
        return "./index";
    }
}
