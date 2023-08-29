package com.example.carrental.controller.maintenance;

import com.example.carrental.service.RentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RentalManagementController {

    private final RentService rentService;

    @GetMapping(value = "${car-rental.endpoint.rentalManagement}")
    public String getRentalManagement(Model model) {
        return rentService.getRentals(model);
    }

    @PostMapping(value = "${car-rental.endpoint.rentalManagement}")
    public String cancelRental(Model model, Long rentalId) {
        rentService.cancelRental(rentalId);
        return getRentalManagement(model);
    }
}
