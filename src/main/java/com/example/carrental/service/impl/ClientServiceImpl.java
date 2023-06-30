package com.example.carrental.service.impl;

import com.example.carrental.dto.ClientDto;
import com.example.carrental.mapper.ClientMapper;
import com.example.carrental.model.Clients;
import com.example.carrental.repository.ClientsRepository;
import com.example.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.RedirectView;

@Component
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientsRepository clientsRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RedirectView registerClient(ClientDto clientDto) {
        final Clients clients = ClientMapper.mapToEntity(clientDto);
        clients.setPassword(passwordEncoder.encode(clients.getPassword()));
        clientsRepository.save(clients);
        return new RedirectView("/login");
    }
}
