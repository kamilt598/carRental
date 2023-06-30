package com.example.carrental.service;

import com.example.carrental.model.Rentals;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

public interface CarService {

    RedirectView selectCars(Rentals rental, RedirectAttributes redirectAttributes);

    String getAllCars(Model model);
}
