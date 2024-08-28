package com.example.findarun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findarun.model.User;
import java.util.*;

public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByUsername(String username);

    User findByFirstNameContainingOrLastNameContaining(String name, String name2);

    Optional<User> findByEmail(String email);
    
}
