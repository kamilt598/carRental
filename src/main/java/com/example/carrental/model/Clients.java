package com.example.carrental.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients", uniqueConstraints = {
        @UniqueConstraint(columnNames = "phoneNumber"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "nick")
})
@Builder
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nick;
    private String password;
    private String roles = "ROLE_USER";
    private Boolean enable = true;
}
