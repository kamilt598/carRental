package com.example.carrental.Controller;


import com.example.carrental.Model.Cars;
import com.example.carrental.Model.Clients;
import com.example.carrental.Model.Places;
import com.example.carrental.Model.Rentals;
import com.example.carrental.Repository.CarsRepository;
import com.example.carrental.Repository.ClientsRepository;
import com.example.carrental.Repository.PlacesRepository;
import com.example.carrental.Repository.RentalsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://api.nbp.pl/api/exchangerates/rates/a/usd?format=json";
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(fooResourceUrl, Object.class);
        Object object = responseEntity.getBody();

        model.addAttribute("carsList", carsList);
        model.addAttribute("placesList", placesList);
        model.addAttribute("clientsList", clientsList);
        return "index";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public RedirectView postTrips(@ModelAttribute Rentals rentals, @RequestParam("carId") Long carId) {
        rentals.setCar(carsRepository.getById(carId));
        rentals.setClient(clientsRepository.getById(1L));
        rentalsRepository.save(rentals);
        return new RedirectView("/myTrips");
    }


}
