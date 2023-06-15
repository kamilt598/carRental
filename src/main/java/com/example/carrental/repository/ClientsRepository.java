package com.example.carrental.repository;

import com.example.carrental.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
    Clients findByNick(String nick);

}
