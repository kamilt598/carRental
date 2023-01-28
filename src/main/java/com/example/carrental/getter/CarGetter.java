package com.example.carrental.getter;

import com.example.carrental.dto.CarDto;
import com.example.carrental.model.Cars;
import com.example.carrental.repository.CarsRepository;
import com.example.carrental.service.GetRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarGetter {

    private static BigDecimal EUR_RATE;
    private static BigDecimal USD_RATE;
    private final CarsRepository carsRepository;

    @PostConstruct
    private void setRates() {
        EUR_RATE = GetRatesService.getRates("EUR");
        USD_RATE = GetRatesService.getRates("USD");
    }

    public List<CarDto> getCars() {
        return entityToDTO(carsRepository.findAll());
    }

    public static CarDto entityToDTO(Cars cars) {
        return CarDto.builder()
                .id(cars.getId())
                .brand(cars.getBrand())
                .model(cars.getModel())
                .type(cars.getType())
                .productionYear(cars.getProductionYear())
                .engine(cars.getEngine())
                .color(cars.getColor())
                .isRented(cars.getIsRented())
                .picture(cars.getPicture())
                .price(cars.getPrice())
                .location(cars.getLocation())
                .priceEur(cars.getPrice().divide(EUR_RATE, RoundingMode.HALF_UP))
                .priceUsd(cars.getPrice().divide(USD_RATE, RoundingMode.HALF_UP))
                .build();
    }

    public static List<CarDto> entityToDTO(List<Cars> carsList) {
        return carsList.stream()
                .map(CarGetter::entityToDTO)
                .collect(Collectors.toList());
    }

    public static Cars DTOToEntity(CarDto carDto) {
        return Cars.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .type(carDto.getType())
                .productionYear(carDto.getProductionYear())
                .engine(carDto.getEngine())
                .color(carDto.getColor())
                .isRented(carDto.getIsRented())
                .picture(carDto.getPicture())
                .price(carDto.getPrice())
                .location(carDto.getLocation())
                .build();
    }

    public static List<Cars> DTOToEntity(List<CarDto> carDtos) {
        return carDtos.stream()
                .map(CarGetter::DTOToEntity)
                .collect(Collectors.toList());
    }
}
