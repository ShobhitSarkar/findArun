package com.example.findarun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findarun.model.Event;
import com.example.findarun.model.RunClub;

public interface EventRepository extends JpaRepository <Event, Long> {

    List<Event> findByRunClub(RunClub runClub);


    
}
