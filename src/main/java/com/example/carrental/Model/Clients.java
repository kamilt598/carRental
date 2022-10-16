package com.example.carrental.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients")
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
