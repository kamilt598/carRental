package com.example.carrental.Controller;


import com.example.carrental.Model.Cars;
import com.example.carrental.Model.Clients;
import com.example.carrental.Model.Places;
import com.example.carrental.Model.Rentals;
import com.example.carrental.Repository.CarsRepository;
import com.example.carrental.Repository.ClientsRepository;
import com.example.carrental.Repository.PlacesRepository;
import com.example.carrental.Repository.RentalsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class Index {

    private final CarsRepository carsRepository;
    private final PlacesRepository placesRepository;
    private final RentalsRepository rentalsRepository;
    private final ClientsRepository clientsRepository;

    public Index(CarsRepository carsRepository, PlacesRepository placesRepository, RentalsRepository rentalsRepository, ClientsRepository clientsRepository) {
        this.carsRepository = carsRepository;
        this.placesRepository = placesRepository;
        this.rentalsRepository = rentalsRepository;
        this.clientsRepository = clientsRepository;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getIndex(Model model) {
        List<Cars> carsList = carsRepository.findAll();
        List<Places> placesList = placesRepository.findAll();
        List<Clients> clientsList = clientsRepository.findAll();
        model.addAttribute("carsList", carsList);
        model.addAttribute("placesList", placesList);
        model.addAttribute("clientsList", clientsList);
        return "index";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public RedirectView postTrips(@ModelAttribute Rentals rentals, @RequestParam Long carId) {
        rentals.setCar(carsRepository.getById(carId));
        rentals.setClient(clientsRepository.getById(1L));
        rentalsRepository.save(rentals);
        return new RedirectView("/myTrips");
    }


}
