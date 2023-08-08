package com.example.carrental.controller;

import com.example.carrental.service.HomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping(value = "${car-rental.endpoint.home}")
    public String getHomeView(Model model) {
        return homeService.getHomeView(model);
    }
}
