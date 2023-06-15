package com.example.carrental.repository;

import com.example.carrental.model.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalsRepository extends JpaRepository<Rentals, Long> {
    List<Rentals> findByClientId_Nick(String nick);
}
