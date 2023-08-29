package com.example.carrental.repository;

import com.example.carrental.model.Place;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    @Cacheable("places")
    Place findByCity(String city);

    @Cacheable("places")
    List<Place> findAll();

    @Cacheable("places")
    List<Place> findAll(Sort sort);

    @CacheEvict(value = "places", allEntries = true)
    void delete(Place entity);

    @CacheEvict(value = "places", allEntries = true)
    <S extends Place> S save(S entity);
}
