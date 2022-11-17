package com.example.carrental.Controller.impl;

import com.example.carrental.Controller.CarRentalController;
import com.example.carrental.Model.Cars;
import com.example.carrental.Model.Clients;
import com.example.carrental.Model.Places;
import com.example.carrental.Model.Rentals;
import com.example.carrental.Repository.CarsRepository;
import com.example.carrental.Repository.ClientsRepository;
import com.example.carrental.Repository.PlacesRepository;
import com.example.carrental.Repository.RentalsRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CarRentalControllerImpl implements CarRentalController {

    private static final String USD_CURRENCY = "usd";
    private static final String EUR_CURRENCY = "eur";

    private final CarsRepository carsRepository;
    private final PlacesRepository placesRepository;
    private final RentalsRepository rentalsRepository;
    private final ClientsRepository clientsRepository;

    @Override
    public String getIndex(Model model) {
        List<Cars> carsList = carsRepository.findAll();
        List<Places> placesList = placesRepository.findAll();
        List<Clients> clientsList = clientsRepository.findAll();
//        for (Cars cars : carsList) {
//                cars.setPriceUSD(cars.getPrice().divide(BigDecimal.valueOf(getRates(USD_CURRENCY))));
//                cars.setPriceEUR(cars.getPrice().divide(BigDecimal.valueOf(getRates(EUR_CURRENCY))));
//                carsRepository.save(cars);
//            }
        model.addAttribute("carsList", carsList);
        model.addAttribute("placesList", placesList);
        model.addAttribute("clientsList", clientsList);
        return "./index";
    }

    private Long getRates(String currency) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl
                    = "https://api.nbp.pl/api/exchangerates/rates/a/" + currency + "?format=json";
            ResponseEntity<String> response
                    = restTemplate.getForEntity(fooResourceUrl, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rates = mapper.readTree(response.getBody()).path("rates");
            return rates.get(0).path("mid").asLong();
        } catch (Exception e) {
            log.info("Exception while mapping response", e);
            return 0L;
        }
    }

    @Override
    public RedirectView postTrips(Rentals rentals, Long carId) {
        rentals.setCarId(carsRepository.getById(carId).getId());
        rentals.setClientId(clientsRepository.getById(1L).getId());
        rentals.setPlaceId(placesRepository.getById(1L).getId());
        rentalsRepository.save(rentals);
        return new RedirectView("/myTrips");
    }

    @Override
    public String getTrips(Model model) {
        List<Rentals> rentalsList = rentalsRepository.findAll();
        model.addAttribute("rentalsList", rentalsList);
        return "myTrips";
    }
}
