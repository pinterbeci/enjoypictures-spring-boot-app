package com.aplication.enjoypictures.repository;

import com.aplication.enjoypictures.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    // Select * from User where username == megkapott username
}

