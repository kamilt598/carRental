package com.example.carrental.service;

import com.example.carrental.dto.ClientDto;
import org.springframework.web.servlet.view.RedirectView;

public interface ClientService {

    RedirectView registerClient(ClientDto clientDto);
}
