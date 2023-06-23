package com.example.carrental.repository;

import com.example.carrental.model.Places;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacesRepository extends JpaRepository<Places, Long> {
    List<Places> findByCityNotLike(String city);
}
