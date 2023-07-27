package com.example.carrental.service.impl;

import com.example.carrental.dto.ClientDto;
import com.example.carrental.mapper.ClientMapper;
import com.example.carrental.model.Clients;
import com.example.carrental.repository.ClientsRepository;
import com.example.carrental.repository.RentalsRepository;
import com.example.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

@Component
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientsRepository clientsRepository;
    private final PasswordEncoder passwordEncoder;
    private final RentalsRepository rentalsRepository;

    @Override
    public RedirectView registerClient(Clients client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientsRepository.save(client);
        return new RedirectView("/login");
    }

    @Override
    public String getAccount(String nickname, Model model) {
        final Clients client = clientsRepository.findByNick(nickname);
        model.addAttribute("client", ClientMapper.mapToDto(client));
        return "account";
    }

    @Override
    public String editAccount(String nickname, Model model) {
        final Clients client = clientsRepository.findByNick(nickname);
        model.addAttribute("client", ClientMapper.mapToDto(client));
        return "editAccount";
    }

    @Override
    public String saveAccount(ClientDto clientDto, String password, Model model) {
        Clients client = clientsRepository.findByNick(clientDto.getNick());
        client.setNick(clientDto.getNick());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        if(password != null) {
            client.setPassword(passwordEncoder.encode(password));
        }
        clientsRepository.save(client);
        model.addAttribute("client", clientDto);
        return "account";
    }

    @Override
    public RedirectView deleteAccount(String nickname) {
        final Clients client = clientsRepository.findByNick(nickname);
        rentalsRepository.deleteByClientId(client);
        clientsRepository.delete(client);
        return new RedirectView("/logout");
    }
}
