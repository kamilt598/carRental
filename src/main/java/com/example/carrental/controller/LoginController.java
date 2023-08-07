package com.example.carrental.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping(value = "/login")
    public String getLoginView() {
        return "loginView";
    }

    @PostMapping(value = {"/login"})
    public RedirectView login() {
        return new RedirectView("/");
    }
}
