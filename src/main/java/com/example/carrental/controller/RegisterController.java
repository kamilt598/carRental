package com.example.carrental.controller;


import com.example.carrental.dto.ClientDto;
import com.example.carrental.mapper.ClientMapper;
import com.example.carrental.model.Clients;
import com.example.carrental.repository.ClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final ClientsRepository clientsRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = {"/register"})
    public String getRegisterView() {
        return "register";
    }

    @PostMapping(value = {"/register"})
    public RedirectView registerUser(@ModelAttribute ClientDto clientDTO) {
        final Clients clients = ClientMapper.mapToEntity(clientDTO);
        clients.setPassword(passwordEncoder.encode(clients.getPassword()));
        clientsRepository.save(clients);
        return new RedirectView("/login");
    }

}
