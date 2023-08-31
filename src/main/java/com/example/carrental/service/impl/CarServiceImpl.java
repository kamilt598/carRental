package com.example.carrental.service.impl;

import com.example.carrental.dto.CarDto;
import com.example.carrental.exception.CustomException;
import com.example.carrental.getter.CarGetter;
import com.example.carrental.model.Car;
import com.example.carrental.model.Place;
import com.example.carrental.model.Rental;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.repository.PlaceRepository;
import com.example.carrental.repository.RentalRepository;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarGetter carGetter;
    private final RentalRepository rentalRepository;
    private final PlaceRepository placeRepository;
    private final CarRepository carRepository;
    @Value("${car-rental.endpoint.carSelection}")
    private String carSelection;
    @Value("${car-rental.endpoint.carManagement}")
    private String carManagement;

    @Override
    public RedirectView selectCars(Rental rental, RedirectAttributes redirectAttributes) {
        final List<Long> rentedCarsIds = getRentedCarsIds(rental);
        final List<CarDto> cars = getCars(rental.getPickUpCity(), rentedCarsIds);
        final List<Place> places = placeRepository.findAll();
        redirectAttributes
                .addFlashAttribute("cars", cars)
                .addFlashAttribute("rental", rental)
                .addFlashAttribute("pickUpCities", getPlacesWithoutCity(places, rental.getPickUpCity()))
                .addFlashAttribute("dropOffCities", getPlacesWithoutCity(places, rental.getDropOffCity()));
        return new RedirectView(carSelection, true);
    }

    @Override
    public String getAllCars(Model model, Boolean admin) {
        model.addAttribute("cars", carGetter.getCars());
        return admin ? "admin/carManagement" : "cars";
    }

    @Override
    public String getCarDetails(Model model, Long carId) {
        final List<CarDto> cars = carGetter.getCars();
        model
                .addAttribute("cars", cars)
                .addAttribute("car", cars.stream()
                        .filter(car -> Objects.equals(car.getId(), carId))
                        .findFirst()
                        .orElseThrow());
        return "carDetails";
    }

    @Override
    public RedirectView createCar(Car car, String city) {
        try {
            final Place place = placeRepository.findByCity(city);
            car.setPlace(place);
            carRepository.save(car);
            return new RedirectView(carManagement);
        } catch (Exception e) {
            throw new CustomException(Map.of("error", e.getMessage()), carManagement);
        }
    }

    @Override
    public RedirectView deleteCar(Long carId) {
        try {
            final Car car = carRepository.findById(carId).orElseThrow();
            carRepository.delete(car);
            return new RedirectView(carManagement);
        } catch (Exception e) {
            throw new CustomException(Map.of("error", e.getMessage()), carManagement);
        }
    }

    @Override
    public String editCar(Long carId, Model model) {
        try {
            model.addAttribute("car", carGetter.getCarById(carId));
            return "admin/editCar";
        } catch (Exception e) {
            throw new CustomException(Map.of("error", e.getMessage()), carManagement);
        }
    }

    @Override
    public RedirectView saveCar(CarDto carDto, Long carId) {
        try {
            updateCar(carDto, carId);
            return new RedirectView(carManagement);
        } catch (Exception e) {
            throw new CustomException(Map.of("error", e.getMessage()), carManagement);
        }
    }

    private void updateCar(CarDto carDto, Long carId) {
        final Car car = carRepository.findById(carId).orElseThrow();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setEngine(carDto.getEngine());
        car.setColor(carDto.getColor());
        car.setProductionYear(carDto.getProductionYear());
        car.setPrice(carDto.getPrice());
        car.setType(carDto.getType());
        car.setPicture(carDto.getPicture());
        car.setPlace(placeRepository.findByCity(carDto.getLocation()));
        carRepository.save(car);
    }

    private List<CarDto> getCars(Place place, List<Long> rentedCarsIds) {
        final List<CarDto> cars = carGetter.getCarsFromPlace(place);
        return rentedCarsIds.isEmpty()
                ? cars
                : getCarsNotRented(rentedCarsIds, cars);
    }

    private List<CarDto> getCarsNotRented(List<Long> rentedCarsIds, List<CarDto> cars) {
        return cars.stream()
                .filter(car -> !rentedCarsIds.contains(car.getId()))
                .toList();
    }

    private List<Long> getRentedCarsIds(Rental rental) {
        return rentalRepository.findInDateRange(rental.getStartDate(), rental.getEndDate())
                .stream()
                .map(Rental::getCarId)
                .map(Car::getId)
                .toList();
    }

    private List<Place> getPlacesWithoutCity(List<Place> places, Place city) {
        return places.stream()
                .filter(place -> !Objects.equals(place.getCity(), city.getCity()))
                .collect(Collectors.toList());
    }
}
