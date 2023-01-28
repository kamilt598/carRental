package com.example.carrental.controller;


import com.example.carrental.dto.ClientDto;
import com.example.carrental.getter.ClientGetter;
import com.example.carrental.model.Clients;
import com.example.carrental.repository.ClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequiredArgsConstructor
public class LoginController {

    private final ClientsRepository clientsRepository;
    private final PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(Model model) {
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String postLogin() {
        return "login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String getRegister() {
        return "register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public RedirectView registerUser(@ModelAttribute ClientDto clientDTO) {
        Clients clients = ClientGetter.DTOToEntity(clientDTO);
        clients.setPassword(passwordEncoder.encode(clients.getPassword()));
        clientsRepository.save(clients);
        return new RedirectView("/login");
    }

}
