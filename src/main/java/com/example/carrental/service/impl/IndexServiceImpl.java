package com.example.carrental.service.impl;

import com.example.carrental.repository.PlaceRepository;
import com.example.carrental.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@RequiredArgsConstructor
public class IndexServiceImpl implements IndexService {

    private final PlaceRepository placeRepository;

    @Override
    public String getIndex(Model model) {
        model.addAttribute("placesList", placeRepository.findAll());
        return "./index";
    }
}
