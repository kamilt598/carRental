package com.example.carrental.service.impl;

import com.example.carrental.model.Rentals;
import com.example.carrental.repository.ClientsRepository;
import com.example.carrental.repository.RentalsRepository;
import com.example.carrental.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentalsRepository rentalsRepository;
    private final ClientsRepository clientsRepository;

    @Override
    public RedirectView createRental(Rentals rentals, String nickname) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        rentals.setClientId(clientsRepository.findByNick(authentication.getName()));
        rentalsRepository.save(rentals);
        return new RedirectView("/myRentals");
    }

    @Override
    public String getRentals(Model model, String nickname) {
        final List<Rentals> rentalsList = rentalsRepository.findByClientId_Nick(nickname);
        model.addAttribute("rentalsList", rentalsList);
        return "myRentals";
    }
}
