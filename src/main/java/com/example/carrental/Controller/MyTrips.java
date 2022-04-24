package com.example.carrental.Controller;

import com.example.carrental.Model.Rentals;
import com.example.carrental.Repository.RentalsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MyTrips {

    private final RentalsRepository rentalsRepository;

    public MyTrips(RentalsRepository rentalsRepository) {
        this.rentalsRepository = rentalsRepository;
    }

    @RequestMapping(value = "/myTrips", method = RequestMethod.GET)
    public String getTrips(Model model) {
        List<Rentals> rentalsList = rentalsRepository.findAll();
        model.addAttribute("rentalsList", rentalsList);
        return "myTrips";
    }
}
