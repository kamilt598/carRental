package com.example.carrental.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients")
@Builder
public class Clients {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nick;
    private String password;
    private String roles;
}
