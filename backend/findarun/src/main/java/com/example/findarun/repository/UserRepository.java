package com.example.findarun.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findarun.model.User;


public interface UserRepository extends JpaRepository <User, Long> {
    
}
