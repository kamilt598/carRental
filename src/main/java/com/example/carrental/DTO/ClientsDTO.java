package com.example.carrental.DTO;

import lombok.Data;

@Data
public class ClientsDTO {

    private Long id;
    private String nick;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}
