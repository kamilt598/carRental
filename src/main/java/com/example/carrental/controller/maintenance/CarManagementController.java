package com.example.carrental.controller.maintenance;

import com.example.carrental.dto.CarDto;
import com.example.carrental.model.Car;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CarManagementController {

    private final CarService carService;

    @GetMapping(value = "${car-rental.endpoint.carManagement}")
    public String getCarManagement(Model model) {
        return carService.getAllCars(model, true);
    }

    @PostMapping(value = "${car-rental.endpoint.carManagement}")
    public RedirectView createCar(Car car, String city) {
        return carService.createCar(car, city);
    }

    @GetMapping(value = "${car-rental.endpoint.deleteCar}")
    public RedirectView deleteCar(@PathVariable Long carId) {
        return carService.deleteCar(carId);
    }

    @GetMapping(value = "${car-rental.endpoint.editCar}")
    public String editCar(@PathVariable Long carId, Model model) {
        return carService.editCar(carId, model);
    }

    @PostMapping(value = "${car-rental.endpoint.editCar}")
    public RedirectView saveCar(@PathVariable Long carId, CarDto carDto) {
        return carService.saveCar(carDto, carId);
    }
}
