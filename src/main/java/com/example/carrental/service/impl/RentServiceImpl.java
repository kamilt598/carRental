package com.example.carrental.service.impl;

import com.example.carrental.model.Rental;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.repository.UserRepository;
import com.example.carrental.repository.RentalRepository;
import com.example.carrental.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Override
    public RedirectView createRental(Rental rental, String nickname, Long carId) {
        rental.setUserId(userRepository.findByNick(nickname).orElseThrow());
        rental.setCarId(carRepository.findById(carId).orElseThrow());
        rentalRepository.save(rental);
        return new RedirectView("/my-rentals");
    }

    @Override
    public String getRentals(Model model, String nickname) {
        final List<Rental> rentalList = rentalRepository.findByUserIdNick(nickname);
        model.addAttribute("rentalsList", rentalList);
        return "myRentals";
    }

    @Override
    public void cancelRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }
}
