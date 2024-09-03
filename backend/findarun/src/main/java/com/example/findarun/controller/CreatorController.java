package com.example.findarun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.findarun.repository.CreatorRepository;

@RestController
@RequestMapping("/api/creators")
public class CreatorController {

    @Autowired
    private CreatorRepository creatorRepository; 
    
    @Autowired 
    private CreatorService creatorService;


    
}
