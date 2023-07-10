package com.example.carrental.mapper;

import com.example.carrental.dto.ClientDto;
import com.example.carrental.model.Clients;

public class ClientMapper {

    public static ClientDto mapToDto(Clients clients) {
        return ClientDto.builder()
                .nick(clients.getNick())
                .email(clients.getEmail())
                .firstName(clients.getFirstName())
                .lastName(clients.getLastName())
                .phoneNumber(clients.getPhoneNumber())
                .build();
    }

    public static Clients mapToEntity(ClientDto clientDTO) {
        return Clients.builder()
                .nick(clientDTO.getNick())
                .email(clientDTO.getEmail())
                .firstName(clientDTO.getFirstName())
                .lastName(clientDTO.getLastName())
                .phoneNumber(clientDTO.getPhoneNumber())
                .build();
    }
}
