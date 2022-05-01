package com.example.carrental.Controller;

import com.example.carrental.Model.Cars;
import com.example.carrental.Model.Places;
import com.example.carrental.Repository.CarsRepository;
import com.example.carrental.Repository.PlacesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller
public class IndexLocation {

    private final CarsRepository carsRepository;
    private final PlacesRepository placesRepository;
    public static String choosenPickUpCity = "";

    public IndexLocation(CarsRepository carsRepository, PlacesRepository placesRepository) {
        this.carsRepository = carsRepository;
        this.placesRepository = placesRepository;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String getIndex(Model model) throws JsonProcessingException {
        List<Cars> carsList = carsRepository.findAll();
        List<Places> placesList = placesRepository.findAll();
        Index.exchangeToPLN(carsRepository, carsList);
        model.addAttribute("carsList", carsList);
        model.addAttribute("placesList", placesList);
        return "indexLocation";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public RedirectView postTrips(@RequestParam("pickUpCity") String pickUpCity) {
        choosenPickUpCity = pickUpCity;
        return new RedirectView("/index");
    }

}
