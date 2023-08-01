package com.example.carrental.controller;

import com.example.carrental.dto.ClientDto;
import com.example.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccountController {

    private final ClientService clientService;

    @GetMapping(value = {"/my-account"})
    public String getAccount(Principal principal, Model model) {
        return clientService.getAccount(principal.getName(), model);
    }

    @GetMapping(value = {"/edit-account"})
    public String editAccount(Principal principal, Model model) {
        return clientService.editAccount(principal.getName(), model);
    }

    @PostMapping(value = {"/edit-account"})
    public String saveAccount(Principal principal, ClientDto client, String password, Model model) {
        return clientService.saveAccount(principal.getName(), client, password, model);
    }

    @PostMapping(value = {"/account"})
    public RedirectView deleteAccount(Principal principal) {
        return clientService.deleteAccount(principal.getName());
    }
}
