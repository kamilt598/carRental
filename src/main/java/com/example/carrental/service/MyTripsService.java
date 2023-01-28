package com.example.carrental.service;

import com.example.carrental.model.Rentals;
import com.example.carrental.repository.CarsRepository;
import com.example.carrental.repository.ClientsRepository;
import com.example.carrental.repository.PlacesRepository;
import com.example.carrental.repository.RentalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyTripsService {

    private final CarsRepository carsRepository;
    private final PlacesRepository placesRepository;
    private final RentalsRepository rentalsRepository;
    private final ClientsRepository clientsRepository;
    public RedirectView postTrips(Rentals rentals, Long carId) {
        rentals.setCarId(carsRepository.getById(carId).getId());
        rentals.setClientId(clientsRepository.getById(1L).getId());
        rentals.setPlaceId(placesRepository.getById(1L).getId());
        rentalsRepository.save(rentals);
        return new RedirectView("/myTrips");
    }

    public String getTrips(Model model) {
        List<Rentals> rentalsList = rentalsRepository.findAll();
        model.addAttribute("rentalsList", rentalsList);
        return "myTrips";
    }
}
