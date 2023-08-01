package com.example.carrental.service.impl;

import com.example.carrental.dto.ClientDto;
import com.example.carrental.mapper.ClientMapper;
import com.example.carrental.model.Clients;
import com.example.carrental.repository.ClientsRepository;
import com.example.carrental.repository.RentalsRepository;
import com.example.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientsRepository clientsRepository;
    private final PasswordEncoder passwordEncoder;
    private final RentalsRepository rentalsRepository;

    @Override
    public RedirectView registerClient(Clients client, RedirectAttributes redirectAttributes) {
        try {
            validateClient(client.getNick(), client.getPhoneNumber(), client.getEmail());
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            clientsRepository.save(client);
            return new RedirectView("/login");
        } catch (Exception e) {
            log.error("[{}] Cannot register new client with nick {}", e.getMessage(), client.getNick());
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            redirectAttributes.addFlashAttribute("client", client);
            return new RedirectView("/register");
        }
    }

    @Override
    public String getAccount(String nickname, Model model) {
        final Clients client = clientsRepository.findByNick(nickname).orElseThrow();
        model.addAttribute("client", ClientMapper.mapToDto(client));
        return "account";
    }

    @Override
    public String editAccount(String nickname, Model model) {
        final Clients client = clientsRepository.findByNick(nickname).orElseThrow();
        ;
        model.addAttribute("client", ClientMapper.mapToDto(client));
        return "editAccount";
    }

    @Override
    public String saveAccount(String nickname, ClientDto clientDto, String password, Model model) {
        try {
            Clients client = clientsRepository.findByNick(nickname).orElseThrow();
            validateClient(client, clientDto);
            client.setNick(clientDto.getNick());
            client.setFirstName(clientDto.getFirstName());
            client.setLastName(clientDto.getLastName());
            client.setEmail(clientDto.getEmail());
            client.setPhoneNumber(clientDto.getPhoneNumber());
            if (password != null) {
                client.setPassword(passwordEncoder.encode(password));
            }
            clientsRepository.save(client);
            model.addAttribute("client", clientDto);
            return "account";
        } catch (Exception e) {
            log.error("[{}] Cannot save data for nick {}", e.getMessage(), nickname);
            model.addAttribute("error", e.getMessage());
            model.addAttribute("client", clientDto);
            return "editAccount";
        }
    }

    @Override
    public RedirectView deleteAccount(String nickname) {
        final Clients client = clientsRepository.findByNick(nickname).orElseThrow();
        ;
        rentalsRepository.deleteByClientId(client);
        clientsRepository.delete(client);
        return new RedirectView("/logout");
    }

    private void validateClient(Clients client, ClientDto clientDto) {
        String nick = null;
        String phoneNumber = null;
        String email = null;
        if (!Objects.equals(client.getNick(), clientDto.getNick())) {
            nick = clientDto.getNick();
        }
        if (!Objects.equals(client.getPhoneNumber(), clientDto.getPhoneNumber())) {
            phoneNumber = clientDto.getPhoneNumber();
        }
        if (!Objects.equals(client.getEmail(), clientDto.getEmail())) {
            email = clientDto.getEmail();
        }
        validateClient(nick, phoneNumber, email);
    }

    private void validateClient(String nick, String phoneNumber, String email) {
        if (Objects.nonNull(nick) && clientsRepository.findByNick(nick).isPresent()) {
            throw new RuntimeException("The nickname already exists");
        }
        if (Objects.nonNull(phoneNumber) && clientsRepository.findByPhoneNumber(phoneNumber).isPresent()) {
            throw new RuntimeException("The phone number is taken by another user");
        }
        if (Objects.nonNull(email) && clientsRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("The e-mail is taken by another user");
        }
    }
}
