package com.example.findarun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.findarun.repository.RunClubRepository;

@RestController
@RequestMapping("/api/runclub")
public class RunClubController {

    @Autowired
    private RunClubRepository runClubRepository; 

    // @Autowired 
    // private RunClubService runClubService; 
    

    
}
