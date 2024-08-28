package com.example.findarun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.findarun.repository.ParticipantRepository;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired 
    private ParticipantRepository participantRepository; 

    // @Autowired
    // private ParticipantService participantService;
    
}
