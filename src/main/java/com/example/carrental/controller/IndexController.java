package com.example.carrental.controller;

import com.example.carrental.service.impl.IndexServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final IndexServiceImpl indexServiceImpl;

    @GetMapping(value = {"/", "/index"})
    public String getIndex(Model model) {
        return indexServiceImpl.getIndex(model);
    }
}
