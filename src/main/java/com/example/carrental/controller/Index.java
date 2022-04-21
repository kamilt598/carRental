package com.example.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }

}
