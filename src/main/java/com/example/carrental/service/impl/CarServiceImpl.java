package com.example.carrental.service.impl;

import com.example.carrental.dto.CarDto;
import com.example.carrental.getter.CarGetter;
import com.example.carrental.model.Car;
import com.example.carrental.model.Place;
import com.example.carrental.model.Rental;
import com.example.carrental.repository.PlaceRepository;
import com.example.carrental.repository.RentalRepository;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarGetter carGetter;
    private final RentalRepository rentalRepository;
    private final PlaceRepository placeRepository;

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
        return new RedirectView("/car-selection", true);
    }

    @Override
    public String getAllCars(Model model) {
        model.addAttribute("cars", carGetter.getCars());
        return "carView";
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
        return "car-single";
    }

    @Override
    public String getCarSelection(Model model) {
        final List<Place> places = placeRepository.findAll();
        model
                .addAttribute("pickUpCities", places)
                .addAttribute("dropOffCities", places);
        return "carSelection";
    }

    private List<CarDto> getCars(Place place, List<Long> rentedCarsIds) {
        return rentedCarsIds.size() != 0
                ? carGetter.getCarsFromPlaceWithoutIds(place, rentedCarsIds)
                : carGetter.getCarsFromPlace(place);
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
                .filter(place -> !place.equals(city))
                .collect(Collectors.toList());
    }
}
