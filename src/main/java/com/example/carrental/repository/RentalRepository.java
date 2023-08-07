package com.example.carrental.repository;

import com.example.carrental.model.User;
import com.example.carrental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    void deleteByUserId(User userId);

    List<Rental> findByEndDate(LocalDate endDate);

    List<Rental> findByUserIdNick(String nick);

    @Query("""
            select r from Rental r
            where r.startDate between ?1 and ?2 or r.endDate between ?1 and ?2 or (r.startDate <= ?1 and r.endDate >= ?2)""")
    List<Rental> findInDateRange(LocalDate startDate, LocalDate endDate);
}
