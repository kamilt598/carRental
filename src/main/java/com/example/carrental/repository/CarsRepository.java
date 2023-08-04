package com.example.carrental.repository;


import com.example.carrental.model.Cars;
import com.example.carrental.model.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
    List<Cars> findByPlaceAndIdNotIn(Places place, List<Long> ids);

    List<Cars> findByPlace(Places place);
}
