package com.example.findarun.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Participant extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int participantId; 

    // TODO: figure out the relationships between run club and events


    
}
