package com.example.findarun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findarun.model.RunClub;

public interface RunClubRepository extends JpaRepository <RunClub, Long> {
    
}
