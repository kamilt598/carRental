package com.example.carrental.service.impl;

import com.example.carrental.exception.CustomException;
import com.example.carrental.model.Rental;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.repository.RentalRepository;
import com.example.carrental.repository.UserRepository;
import com.example.carrental.service.RentService;
import com.example.carrental.service.UserDataValidator;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "car-rental.endpoint")
public class RentServiceImpl implements RentService {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final UserDataValidator userDataValidator;
    @Setter
    private String carSelection;
    @Setter
    private String myRentals;

    @Override
    public RedirectView createRental(Rental rental, String nickname, Long carId) {
        rental.setUserId(userRepository.findByNick(nickname)
                .orElseThrow(userDataValidator.handleIfUserCouldNotBeFound(nickname, carSelection)));
        rental.setCarId(carRepository.findById(carId)
                .orElseThrow(() -> new CustomException(Map.of("error", String.format("Cannot find car with id %s", carId)), carSelection)));
        rentalRepository.save(rental);
        return new RedirectView(myRentals);
    }

    @Override
    public String getRentalsView(Model model, String nickname) {
        final List<Rental> rentalList = rentalRepository.findByUserIdNick(nickname);
        model.addAttribute("rentalsList", rentalList);
        return "myRentals";
    }

    @Override
    public void cancelRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }
}
