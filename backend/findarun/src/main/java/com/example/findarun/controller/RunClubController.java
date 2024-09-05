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

import com.example.findarun.model.Event;
import com.example.findarun.model.RunClub;
import com.example.findarun.model.User;
import com.example.findarun.service.RunClubService;

@RestController
@RequestMapping("/api/runclub")
public class RunClubController {

    @Autowired
    RunClubService runClubService; 

    @PostMapping
    public ResponseEntity<RunClub> createRunClub(@RequestBody RunClub runClubDetails){

        RunClub newRunClub = runClubService.createRunClub(runClubDetails); 

        return ResponseEntity.ok(newRunClub); 
    }

    @GetMapping("/{runClubId}")
    public ResponseEntity<RunClub> getRunClub(@PathVariable Long runClubId){

        RunClub runclub = runClubService.getRunClub(runClubId);

        return ResponseEntity.ok(runclub);
    }

    @GetMapping
    public ResponseEntity<List<RunClub>> getAllRunClubs(){

        List<RunClub> runClubs = runClubService.getAllRunClubs(); 

        return ResponseEntity.ok(runClubs);

    }

    @PutMapping("/{runclubId}")
    public ResponseEntity<RunClub> updateRunClub (@RequestBody RunClub runClubDetails){

        RunClub updatedRunClub = runClubService.updateRunClub(runClubDetails); 

        return ResponseEntity.ok(updatedRunClub);
    }

    @DeleteMapping("/{runClubId}")
    public ResponseEntity<Void> deleteRunClub (@PathVariable Long runClubId){

        runClubService.deleteRunClub(runClubId); 

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{runClubId}/addMember/{userId}")
    public ResponseEntity<Void> addMemberToRunClub (@PathVariable Long runClubId, @PathVariable Long userId){

        runClubService.addMember(runClubId, userId); 

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{runClubId}/removeMember/{userId}")
    public ResponseEntity<Void> removeMemberFromRunClub (@PathVariable Long runClubId, @PathVariable Long userId){
        runClubService.removeMember(runClubId, userId); 

        return ResponseEntity.noContent().build(); 
    }

    @GetMapping("/{runClubId}/members")
    public ResponseEntity<List<User>> getAllRunClubMembers (@PathVariable Long runClubId){
        
        List<User> runClubMembers = runClubService.getAllRunClubMembers(runClubId); 

        return ResponseEntity.ok(runClubMembers);
    }

    @GetMapping("/{runClubId}/events")
    public ResponseEntity<List<Event>> getAllRunClubEvents (@PathVariable Long runClubId){

        List<Event> runClubEvents = runClubService.getAllRunClubEvents(runClubId); 

        return ResponseEntity.ok(runClubEvents);
    }

    @PostMapping("/{runClubId}/events")
    public ResponseEntity<Event> createEvent(@PathVariable Long runClubId, @RequestBody Event event) {
        Event newEvent = runClubService.createEventForRunClub(runClubId, event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    /**
     * TODO : other possible methods to implement : 
     * 
     * 1) get runclub by location 
     * 2) get runclub statistics 
     */




    

    
}
