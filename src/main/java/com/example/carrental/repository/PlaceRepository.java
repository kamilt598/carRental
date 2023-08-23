package com.example.carrental.repository;

import com.example.carrental.model.Place;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Cacheable("places")
    List<Place> findAll();
}
