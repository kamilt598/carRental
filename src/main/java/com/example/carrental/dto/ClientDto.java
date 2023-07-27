package com.example.carrental.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    private String nick;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
