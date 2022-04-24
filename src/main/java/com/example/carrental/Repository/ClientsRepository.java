package com.example.carrental.Repository;

import com.example.carrental.Model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
    Clients save(Clients clients);
    Optional<Clients> findById(Long id);
    List<Clients> findAll();
}
