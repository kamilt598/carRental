package com.example.carrental.Repository;

import com.example.carrental.Model.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PlacesRepository extends JpaRepository<Places, Long> {
    Places save(Places places);
    Optional<Places> findById(Long id);
    List<Places> findAll();
}
