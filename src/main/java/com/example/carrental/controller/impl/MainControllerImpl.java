package com.example.carrental.controller.impl;

import com.example.carrental.controller.MainController;
import com.example.carrental.model.Rentals;
import com.example.carrental.service.IndexService;
import com.example.carrental.service.MyTripsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainControllerImpl implements MainController {

    private final IndexService indexService;
    private final MyTripsService myTripsService;

    @Override
    public String getIndex(Model model) {
        return indexService.getIndex(model);
    }

    @Override
    public RedirectView postTrips(Rentals rentals, Long carId) {
        return myTripsService.postTrips(rentals, carId);
    }

    @Override
    public String getTrips(Model model) {
        return myTripsService.getTrips(model);
    }
}
