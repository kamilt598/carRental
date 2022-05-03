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


import java.sql.Date;
import java.util.List;
@Controller
public class IndexLocation {

    private final CarsRepository carsRepository;
    private final PlacesRepository placesRepository;
    public static String choosenPickUpCity = "";
    public static String choosenDropOffCity = "";
    public static Date choosenStartDate;
    public static Date choosenEndDate;

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
    public RedirectView postTrips(@RequestParam("pickUpCity") String pickUpCity,
                                  @RequestParam("dropOffCity") String dropOffCity,
                                  @RequestParam("startDate") Date startDate,
                                  @RequestParam("endDate") Date endDate) {
        choosenPickUpCity = pickUpCity;
        choosenDropOffCity = dropOffCity;
        choosenStartDate = startDate;
        choosenEndDate = endDate;
        return new RedirectView("/index");
    }

}
