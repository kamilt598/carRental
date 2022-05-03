package com.example.carrental.Controller;


import com.example.carrental.Converter.ClientsConverter;
import com.example.carrental.DTO.ClientsDTO;
import com.example.carrental.Model.Clients;
import com.example.carrental.Repository.ClientsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class Login {

    private final ClientsRepository clientsRepository;
    private final ClientsConverter clientsConverter;
    private final PasswordEncoder passwordEncoder;

    public Login(ClientsRepository clientsRepository, ClientsConverter clientsConverter, PasswordEncoder passwordEncoder) {
        this.clientsRepository = clientsRepository;
        this.clientsConverter = clientsConverter;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(Model model) {
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String postLogin() {
        return "login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String getRegister() { return "register"; }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public RedirectView registerUser(@ModelAttribute ClientsDTO clientsDTO) {
        Clients clients = clientsConverter.DTOToEntity(clientsDTO);
        clients.setPassword(passwordEncoder.encode(clients.getPassword()));
        clientsRepository.save(clients);
        return new RedirectView("/login");
    }

}
