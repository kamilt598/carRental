package com.example.carrental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ServicesController {
    @GetMapping(value = "${car-rental.endpoint.services}")
    public String getServices() {
        return "services";
    }
}
