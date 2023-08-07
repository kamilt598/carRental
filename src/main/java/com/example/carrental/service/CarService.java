package com.example.carrental.service;

import com.example.carrental.model.Rental;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

public interface CarService {

    RedirectView selectCars(Rental rental, RedirectAttributes redirectAttributes);

    String getAllCars(Model model);

    String getCarDetails(Model model, Long carIdid);

    String getCarSelection(Model model);
}
