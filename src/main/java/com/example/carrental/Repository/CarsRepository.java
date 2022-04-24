package com.example.carrental.Repository;


import com.example.carrental.Model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
    Cars save(Cars cars);
    Optional<Cars> findById(Long id);
    List<Cars> findAll();

}
