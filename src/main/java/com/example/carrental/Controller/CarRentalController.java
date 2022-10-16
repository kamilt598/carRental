package com.example.carrental.Controller;

import com.example.carrental.Model.Rentals;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

public interface CarRentalController {

    @GetMapping(value = {"/", "/index"})
    String getIndex(Model model);

    @PostMapping(value = {"/", "/index"})
    RedirectView postTrips(@ModelAttribute Rentals rentals, @RequestParam("carId") Long carId);

    @GetMapping(value = "/myTrips")
    String getTrips(Model model);
}