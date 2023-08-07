package com.example.carrental.repository;

import com.example.carrental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByNick(String nick);

    Optional<User> findByEmail(String email);
}
