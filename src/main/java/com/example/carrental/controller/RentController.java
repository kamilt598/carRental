package com.example.carrental.controller;

import com.example.carrental.model.Rentals;
import com.example.carrental.service.RentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;

    @PostMapping(value = {"/", "/index"})
    public RedirectView createRental(Principal principal, Rentals rentals) {
        return rentService.createRental(rentals, principal.getName());
    }

    @GetMapping(value = "/myRentals")
    public String getRentals(Principal principal, Model model) {
        return rentService.getRentals(model, principal.getName());
    }
}
