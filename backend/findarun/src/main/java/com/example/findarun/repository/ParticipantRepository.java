package com.example.findarun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findarun.model.Participant;

public interface ParticipantRepository extends JpaRepository <Participant, Long>{
    
    
}
