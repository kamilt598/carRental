package com.example.carrental.controller;


import com.example.carrental.dto.ClientDto;
import com.example.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final ClientService clientService;

    @GetMapping(value = {"/register"})
    public String getRegisterView() {
        return "register";
    }

    @PostMapping(value = {"/register"})
    public RedirectView register(@ModelAttribute ClientDto clientDto) {
        return clientService.registerClient(clientDto);
    }
}
