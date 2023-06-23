package com.example.carrental.getter;

import com.example.carrental.dto.CarDto;
import com.example.carrental.model.Cars;
import com.example.carrental.repository.CarsRepository;
import com.example.carrental.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarGetter {

    private final CarsRepository carsRepository;
    private final RateService rateService;

    public List<CarDto> getCars() {
        return mapToDto(carsRepository.findAll());
    }

    public List<CarDto> getCarsWithoutIds(List<Long> ids) {
        return mapToDto(carsRepository.findByIdNotIn(ids));
    }

    private CarDto mapToDto(Cars cars) {
        return CarDto.builder()
                .id(cars.getId())
                .brand(cars.getBrand())
                .model(cars.getModel())
                .type(cars.getType())
                .productionYear(cars.getProductionYear())
                .engine(cars.getEngine())
                .color(cars.getColor())
                .picture(cars.getPicture())
                .price(cars.getPrice())
                .location(cars.getLocation())
                .priceEur(cars.getPrice().divide(rateService.getRates("EUR"), RoundingMode.HALF_UP))
                .priceUsd(cars.getPrice().divide(rateService.getRates("USD"), RoundingMode.HALF_UP))
                .build();
    }

    private List<CarDto> mapToDto(List<Cars> carsList) {
        return carsList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
