package com.example.carrental.controller.maintenance;

import com.example.carrental.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PlaceManagementController {

    private final PlaceService placeService;

    @GetMapping(value = "${car-rental.endpoint.placeManagement}")
    public String getPlaceManagement(Model model) {
        return placeService.getPlacesMaintenanceView(model);
    }

    @PostMapping(value = "${car-rental.endpoint.placeManagement}")
    public RedirectView createPlace(String newCity) {
        return placeService.createPlace(newCity);
    }

    @GetMapping(value = "${car-rental.endpoint.deletePlace}")
    public RedirectView deletePlace(@PathVariable String city) {
        return placeService.deletePlace(city);
    }
}
