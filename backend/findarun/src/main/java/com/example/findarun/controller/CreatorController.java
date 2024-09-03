package com.example.findarun.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.findarun.model.Creator;
import com.example.findarun.model.Event;
import com.example.findarun.model.RunClub;
import com.example.findarun.repository.CreatorRepository;
import com.example.findarun.service.CreatorService;

@RestController
@RequestMapping("/api/creators")
public class CreatorController {

    @Autowired
    private CreatorRepository creatorRepository; 
    
    @Autowired 
    private CreatorService creatorService;

    @PostMapping
    public ResponseEntity<Creator> createCreator (@RequestBody Creator creator){
        Creator newCreator = creatorService.createCreator(creator); 

        return new ResponseEntity<>(newCreator, HttpStatus.CREATED);
    }

    @GetMapping("/{creatorId}")
    public ResponseEntity<Creator> getCreatorById(@PathVariable Long creatorId) throws Exception{
        Creator creator; 
        
        try{
            creator = creatorService.getCreatorById(creatorId);
        } catch (Exception e){
            throw new Exception("No creator with id" + creatorId + "found !");
        }

        return ResponseEntity.ok(creator);
    }

    @PutMapping("/{creatorId}")
    public ResponseEntity<Creator> updateCreator (@PathVariable Long creatorId, @RequestBody Creator creatorDetails){
        Creator updatedCreator = creatorService.updateCreator(creatorId, creatorDetails); 

        return ResponseEntity.ok(updatedCreator);

    }

    @DeleteMapping("/{creatorId}")
    public ResponseEntity<Void> deleteCreator (@PathVariable Long creatorId) throws Exception{
        try {
            creatorService.deleteCreator(creatorId);
        } catch (Exception e){
            throw new Exception("No creator found  with the id !");
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Creator>> getAllCreators(){
        List<Creator> creators = creatorService.getAllCreators(); 

        return ResponseEntity.ok(creators);

    }

    @PostMapping("/{creatorId}/runclubs")
    public ResponseEntity<RunClub> createRubClub(@PathVariable Long creatorId, @RequestBody RunClub runClub){
        RunClub newRunClub = creatorService.createRunClub(creatorId, runClub); 

        return new ResponseEntity<>(newRunClub, HttpStatus.CREATED); 
    }

    @GetMapping("/{creatorId}/runclubs/{runClubId}/events")
    public ResponseEntity<Event> createEvent (@PathVariable Long creatorId, @PathVariable Long runClubId, @RequestBody Event event){
        Event newEvent = creatorService.createEvent(creatorId, runClubId, event); 

        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @GetMapping("/{creatorId}/events")
    public ResponseEntity<List<Event>> getCreatorEvents(@PathVariable Long creatorId){
       // TODO : need to implement searching for 

       return null;
    }



    
}
