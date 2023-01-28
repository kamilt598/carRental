package com.example.carrental.repository;


import com.example.carrental.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, Long> {

}
