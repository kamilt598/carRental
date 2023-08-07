package com.example.carrental.repository;


import com.example.carrental.model.Car;
import com.example.carrental.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByPlaceAndIdNotIn(Place place, List<Long> ids);

    List<Car> findByPlace(Place place);
}
