package com.example.carrental.service;

import com.example.carrental.model.Rentals;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

public interface RentService {

    RedirectView createRental(Rentals rental, String nickname, Long carId);

    String getRentals(Model model, String nickname);
}
