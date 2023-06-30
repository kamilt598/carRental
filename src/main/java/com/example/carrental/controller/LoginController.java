package com.example.carrental.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping(value = "/login")
    public String getLoginView() {
        return "login";
    }

    @PostMapping(value = {"/login"})
    public String login() {
        return "index";
    }
}
