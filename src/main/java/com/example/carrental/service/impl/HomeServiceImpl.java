package com.example.carrental.service.impl;

import com.example.carrental.repository.PlaceRepository;
import com.example.carrental.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final PlaceRepository placeRepository;

    @Override
    public String getHomeView(Model model) {
        model.addAttribute("placesList", placeRepository.findAll());
        return "home";
    }
}
