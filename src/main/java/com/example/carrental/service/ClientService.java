package com.example.carrental.service;

import com.example.carrental.model.Clients;
import org.springframework.web.servlet.view.RedirectView;

public interface ClientService {

    RedirectView registerClient(Clients client);
}
