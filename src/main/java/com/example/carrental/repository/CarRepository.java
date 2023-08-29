package com.example.carrental.repository;


import com.example.carrental.model.Car;
import com.example.carrental.model.Place;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Cacheable("cars")
    List<Car> findAll();

    @Cacheable(value = "cars", key = "#place")
    List<Car> findByPlace(Place place);

    @CacheEvict(value = "cars", allEntries = true)
    void delete(Car entity);

    @CacheEvict(value = "cars", allEntries = true)
    <S extends Car> S save(S entity);

    @Cacheable("cars")
    Optional<Car> findById(Long aLong);
}
