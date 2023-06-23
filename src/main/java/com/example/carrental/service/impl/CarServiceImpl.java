package com.example.carrental.service.impl;

import com.example.carrental.dto.CarDto;
import com.example.carrental.getter.CarGetter;
import com.example.carrental.getter.PlaceGetter;
import com.example.carrental.model.Cars;
import com.example.carrental.model.Rentals;
import com.example.carrental.repository.RentalsRepository;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarGetter carGetter;
    private final RentalsRepository rentalsRepository;
    private final PlaceGetter placeGetter;

    @Override
    public RedirectView selectCars(Rentals rental, RedirectAttributes redirectAttributes) {
        final List<Long> rentedCarsIds = getRentedCarsIds(rental);
        final List<CarDto> cars = getCars(rentedCarsIds);
        redirectAttributes.addFlashAttribute("cars", cars);
        redirectAttributes.addFlashAttribute("rental", rental);
        redirectAttributes.addFlashAttribute("pickUpCities", placeGetter.getPlacesWithout(rental.getPickUpCity()));
        redirectAttributes.addFlashAttribute("dropOffCities", placeGetter.getPlacesWithout(rental.getDropOffCity()));
        return new RedirectView("/car-selection", true);
    }

    private List<CarDto> getCars(List<Long> rentedCarsIds) {
        return rentedCarsIds.size() != 0
                ? carGetter.getCarsWithoutIds(rentedCarsIds)
                : carGetter.getCars();
    }

    private List<Long> getRentedCarsIds(Rentals rental) {
        return rentalsRepository.findInDateRange(rental.getStartDate(), rental.getEndDate())
                .stream()
                .map(Rentals::getCarId)
                .map(Cars::getId)
                .toList();
    }
}
