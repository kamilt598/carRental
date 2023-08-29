package com.example.carrental.controller.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping(value = "${car-rental.endpoint.login}")
    public String getLoginView() {
        return "loginView";
    }
}
