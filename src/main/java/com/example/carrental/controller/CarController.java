package com.example.carrental.controller;

import com.example.carrental.model.Rental;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping(value = "${car-rental.endpoint.home}")
    public RedirectView selectCars(Rental rental, RedirectAttributes redirectAttributes) {
        return carService.selectCars(rental, redirectAttributes);
    }

    @GetMapping(value = "${car-rental.endpoint.carSelection}")
    public String getCarSelection() {
        return "carSelection";
    }

    @GetMapping(value = "${car-rental.endpoint.cars}")
    public String getCars(Model model) {
        return carService.getAllCars(model, false);
    }

    @GetMapping(value = "${car-rental.endpoint.carDetails}")
    public String getCarDetails(Model model, @PathVariable("carId") Long carId) {
        return carService.getCarDetails(model, carId);
    }
}
