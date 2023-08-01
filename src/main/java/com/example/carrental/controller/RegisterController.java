package com.example.carrental.controller;


import com.example.carrental.model.Clients;
import com.example.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final ClientService clientService;

    @GetMapping(value = {"/register"})
    public String getRegisterView() {
        return "registerView";
    }

    @PostMapping(value = {"/register"})
    public RedirectView register(@ModelAttribute Clients client, RedirectAttributes redirectAttributes) {
        return clientService.registerClient(client, redirectAttributes);
    }
}
