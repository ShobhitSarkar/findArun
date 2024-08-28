package com.example.findarun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findarun.model.Event;

public interface EventRepository extends JpaRepository <Event, Long> {


    
}
