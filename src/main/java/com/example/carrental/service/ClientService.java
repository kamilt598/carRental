package com.example.carrental.service;

import com.example.carrental.dto.ClientDto;
import com.example.carrental.model.Clients;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

public interface ClientService {

    RedirectView registerClient(Clients client);

    String getAccount(String nickname, Model model);

    String editAccount(String nickname, Model model);

    String saveAccount(ClientDto clientDto, String password, Model model);

    RedirectView deleteAccount(String nickname);
}
