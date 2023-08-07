package com.example.carrental.getter;

import com.example.carrental.dto.CarDto;
import com.example.carrental.mapper.CarMapper;
import com.example.carrental.model.Place;
import com.example.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarGetter {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDto> getCars() {
        return carMapper.mapToDto(carRepository.findAll());
    }

    public List<CarDto> getCarsFromPlace(Place place) {
        return carMapper.mapToDto(carRepository.findByPlace(place));
    }

    public List<CarDto> getCarsFromPlaceWithoutIds(Place place, List<Long> ids) {
        return carMapper.mapToDto(carRepository.findByPlaceAndIdNotIn(place, ids));
    }
}
