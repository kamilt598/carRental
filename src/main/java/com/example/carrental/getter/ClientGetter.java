package com.example.carrental.getter;

import com.example.carrental.dto.ClientDto;
import com.example.carrental.model.Clients;
import com.example.carrental.repository.ClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClientGetter {

    private final ClientsRepository clientsRepository;

    public List<ClientDto> getClients() {
        return entityToDTO(clientsRepository.findAll());
    }

    public static ClientDto entityToDTO(Clients clients) {
        return ClientDto.builder()
                .nick(clients.getNick())
                .password(clients.getPassword())
                .email(clients.getEmail())
                .firstName(clients.getFirstName())
                .lastName(clients.getLastName())
                .phoneNumber(clients.getPhoneNumber())
                .build();
    }

    public static List<ClientDto> entityToDTO(List<Clients> clientsList) {
        return clientsList.stream()
                .map(ClientGetter::entityToDTO)
                .collect(Collectors.toList());
    }

    public static Clients DTOToEntity(ClientDto clientDTO) {
        return Clients.builder()
                .nick(clientDTO.getNick())
                .password(clientDTO.getPassword())
                .email(clientDTO.getEmail())
                .firstName(clientDTO.getFirstName())
                .lastName(clientDTO.getLastName())
                .phoneNumber(clientDTO.getPhoneNumber())
                .build();
    }

    public static List<Clients> DTOToEntity(List<ClientDto> clientDtos) {
        return clientDtos.stream()
                .map(ClientGetter::DTOToEntity)
                .collect(Collectors.toList());
    }
}
