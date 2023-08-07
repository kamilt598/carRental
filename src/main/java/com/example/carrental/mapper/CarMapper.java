package com.example.carrental.mapper;

import com.example.carrental.dto.CarDto;
import com.example.carrental.model.Car;
import com.example.carrental.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarMapper {

    private final RateService rateService;

    public CarDto mapToDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .type(car.getType())
                .productionYear(car.getProductionYear())
                .engine(car.getEngine())
                .color(car.getColor())
                .picture(car.getPicture())
                .price(car.getPrice().setScale(0, RoundingMode.HALF_UP))
                .location(car.getPlace().getCity())
                .priceEur(car.getPrice().divide(rateService.getRate("EUR"), 0, RoundingMode.HALF_UP))
                .build();
    }

    public List<CarDto> mapToDto(List<Car> carList) {
        return carList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
