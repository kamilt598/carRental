package com.example.carrental.service.impl;

import com.example.carrental.model.Rentals;
import com.example.carrental.repository.CarsRepository;
import com.example.carrental.repository.ClientsRepository;
import com.example.carrental.repository.RentalsRepository;
import com.example.carrental.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentalsRepository rentalsRepository;
    private final ClientsRepository clientsRepository;
    private final CarsRepository carsRepository;

    @Override
    public RedirectView createRental(Rentals rental, String nickname, Long carId) {
        rental.setClientId(clientsRepository.findByNick(nickname).orElseThrow());
        rental.setCarId(carsRepository.findById(carId).orElseThrow());
        rentalsRepository.save(rental);
        return new RedirectView("/my-rentals");
    }

    @Override
    public String getRentals(Model model, String nickname) {
        final List<Rentals> rentalsList = rentalsRepository.findByClientIdNick(nickname);
        model.addAttribute("rentalsList", rentalsList);
        return "myRentals";
    }

    @Override
    public void cancelRental(Long rentalId) {
        rentalsRepository.deleteById(rentalId);
    }
}
