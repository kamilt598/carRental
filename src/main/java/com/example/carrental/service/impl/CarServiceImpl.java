package com.example.carrental.service.impl;

import com.example.carrental.dto.CarDto;
import com.example.carrental.getter.CarGetter;
import com.example.carrental.model.Cars;
import com.example.carrental.model.Places;
import com.example.carrental.model.Rentals;
import com.example.carrental.repository.PlacesRepository;
import com.example.carrental.repository.RentalsRepository;
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
    private final RentalsRepository rentalsRepository;
    private final PlacesRepository placesRepository;

    @Override
    public RedirectView selectCars(Rentals rental, RedirectAttributes redirectAttributes) {
        final List<Long> rentedCarsIds = getRentedCarsIds(rental);
        final List<CarDto> cars = getCars(rental.getPickUpCity(), rentedCarsIds);
        final List<Places> places = placesRepository.findAll();
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
        final List<Places> places = placesRepository.findAll();
        model
                .addAttribute("pickUpCities", places)
                .addAttribute("dropOffCities", places);
        return "carSelection";
    }

    private List<CarDto> getCars(Places place, List<Long> rentedCarsIds) {
        return rentedCarsIds.size() != 0
                ? carGetter.getCarsFromPlaceWithoutIds(place, rentedCarsIds)
                : carGetter.getCarsFromPlace(place);
    }

    private List<Long> getRentedCarsIds(Rentals rental) {
        return rentalsRepository.findInDateRange(rental.getStartDate(), rental.getEndDate())
                .stream()
                .map(Rentals::getCarId)
                .map(Cars::getId)
                .toList();
    }

    private List<Places> getPlacesWithoutCity(List<Places> places, Places city) {
        return places.stream()
                .filter(place -> !place.equals(city))
                .collect(Collectors.toList());
    }
}
