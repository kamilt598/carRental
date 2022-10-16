package com.example.carrental.Converter;

import com.example.carrental.DTO.ClientsDTO;
import com.example.carrental.Model.Clients;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientsConverter {

    public ClientsDTO entityToDTO(Clients clients) {
        ClientsDTO clientsDTO = new ClientsDTO();
        clientsDTO.setId(clients.getId());
        clientsDTO.setNick(clients.getNick());
        clientsDTO.setPassword(clients.getPassword());
        clientsDTO.setEmail(clients.getEmail());
        clientsDTO.setFirstName(clients.getFirstName());
        clientsDTO.setLastName(clients.getLastName());
        clientsDTO.setPhoneNumber(clients.getPhoneNumber());
        return clientsDTO;
    }

    public List<ClientsDTO> entityToDTO(List<Clients> clientsList) {
        return clientsList.stream()
                .map(x -> entityToDTO(x))
                .collect(Collectors.toList());
    }

    public Clients DTOToEntity(ClientsDTO clientsDTO) {
        Clients clients = new Clients();
        clients.setId(clientsDTO.getId());
        clients.setNick(clientsDTO.getNick());
        clients.setPassword(clientsDTO.getPassword());
        clients.setEmail(clientsDTO.getEmail());
        clients.setFirstName(clientsDTO.getFirstName());
        clients.setLastName(clientsDTO.getLastName());
        clients.setPhoneNumber(clientsDTO.getPhoneNumber());
        return clients;
    }

    public List<Clients> DTOToEntity(List<ClientsDTO> clientsDTOS) {
        return clientsDTOS.stream()
                .map(x -> DTOToEntity(x))
                .collect(Collectors.toList());
    }

}
