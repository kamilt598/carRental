package com.example.carrental.Repository;

import com.example.carrental.Model.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalsRepository extends JpaRepository<Rentals, Long> {
    Rentals save(Rentals rentals);
    List<Rentals> findAll();
}
