package com.example.carrental.service;

import org.springframework.ui.Model;

@FunctionalInterface
public interface HomeService {

    String getHomeView(Model model);
}
