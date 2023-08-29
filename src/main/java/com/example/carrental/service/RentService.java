package com.example.carrental.service;

import com.example.carrental.model.Rental;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

public interface RentService {

    RedirectView createRental(Rental rental, String nickname, Long carId);

    String getRentalsByNickname(Model model, String nickname);
    String getRentals(Model model);

    void cancelRental(Long rentalId);
}
