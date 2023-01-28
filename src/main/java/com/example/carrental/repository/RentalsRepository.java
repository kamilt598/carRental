package com.example.carrental.repository;

import com.example.carrental.model.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalsRepository extends JpaRepository<Rentals, Long> {
}
