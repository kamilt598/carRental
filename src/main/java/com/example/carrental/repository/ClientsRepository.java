package com.example.carrental.repository;

import com.example.carrental.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
    Optional<Clients> findByPhoneNumber(String phoneNumber);

    Optional<Clients> findByNick(String nick);

    Optional<Clients> findByEmail(String email);
}
