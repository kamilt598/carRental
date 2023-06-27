package com.example.carrental.repository;

import com.example.carrental.model.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentalsRepository extends JpaRepository<Rentals, Long> {
    List<Rentals> findByClientIdNick(String nick);

    @Query("""
            select r from Rentals r
            where r.startDate between ?1 and ?2 or r.endDate between ?1 and ?2 or (r.startDate <= ?1 and r.endDate >= ?2)""")
    List<Rentals> findInDateRange(LocalDate startDate, LocalDate endDate);
}
