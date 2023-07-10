package com.example.carrental.controller;

import com.example.carrental.model.Rentals;
import com.example.carrental.service.CarService;
import com.example.carrental.service.RentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;
    private final CarService carService;

    @PostMapping(value = {"/car-selection"})
    public RedirectView createRentalOrSelectCars(Principal principal, Rentals rental,
                                                 Long carId, RedirectAttributes redirectAttributes) {
        return carId != null
                ? rentService.createRental(rental, principal.getName(), carId)
                : carService.selectCars(rental, redirectAttributes);
    }

    @GetMapping(value = "/myRentals")
    public String getRentals(Principal principal, Model model) {
        return rentService.getRentals(model, principal.getName());
    }

    @PostMapping(value = "/myRentals")
    public String cancelRental(Principal principal, Model model, Long rentalId) {
        rentService.cancelRental(rentalId);
        return getRentals(principal, model);
    }
}
