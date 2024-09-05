package com.example.findarun.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.findarun.model.Participant;
import com.example.findarun.model.RunClub;
import com.example.findarun.repository.ParticipantRepository;
import com.example.findarun.service.ParticipantService;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired 
    private ParticipantRepository participantRepository; 

    @Autowired
    private ParticipantService participantService;

    @PostMapping
    public ResponseEntity<Participant> createParticipant (@RequestBody Participant newParticipant){
        Participant participant = new Participant(newParticipant);

        return ResponseEntity.ok(newParticipant);
    }

    @GetMapping("/participantId}")
    public ResponseEntity<Participant> getParticipant (@PathVariable Long participantId){
        Participant participant = participantService.getSingleParticipant(participantId); 
        
        return ResponseEntity.ok(participant); 
    }

    @GetMapping
    public ResponseEntity<List<Participant>> getAllParticipants(){
        List<Participant> participants = participantService.getAllParticipants(); 

        return ResponseEntity.ok(participants);
    }

    @PutMapping("/{participantId}")
    public ResponseEntity<Participant> updateParticipant (@PathVariable Long participantId, @RequestBody Participant updatedParticipant){

        Participant participant = participantService.updateParticipant(participantId, updatedParticipant); 

        return ResponseEntity.ok(updatedParticipant);

    }

    @DeleteMapping("/{participantId}")
    public ResponseEntity<Void> deleteParticipant (@PathVariable Long participantId){
        
        participantService.deleteParticipant(participantId); 

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{participantId}/join/{runClubId}")
    public ResponseEntity<Void> joinRunClub (@PathVariable Long participantId, @PathVariable Long runClubId){

        participantService.joinRunClub(participantId, runClubId); 

        return ResponseEntity.noContent().build(); 
    }

    @PostMapping("/{participantId}/leave/{runClubId}")
    public ResponseEntity<Void> leaveRunClub (@PathVariable Long participantId, @PathVariable Long runClubId){

        participantService.leaveRunClub(participantId, runClubId); 

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{participantId}/runClubs")
    public ResponseEntity<List<RunClub>> getParticipantRunClubs (@PathVariable Long participantId){
        
        List<RunClub> runClubs = participantService.getRunClubs(participantId); 

        return ResponseEntity.ok(runClubs);
    }

    @PutMapping("/{participantId}/register/{eventId}")
    public ResponseEntity<Void> joinEvent (@PathVariable Long participantId, @PathVariable Long eventId){

        participantService.joinEvent(participantId, eventId); 

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{participantId}/unregister/{eventId}")
    public ResponseEntity<Void> leaveEvent (@PathVariable Long pariticpantId, @PathVariable Long eventId){

        participantService.leaveEvent(pariticpantId, eventId); 

        return ResponseEntity.noContent().build(); 
    }

    @GetMapping("/{participantId}/events")
    public ResponseEntity<Void> joinEvent (@PathVariable Long participantId){

        participantService.getParticipantEvents(participantId); 

        return ResponseEntity.noContent().build(); 
    }

    /**
     * Additional things to add : 
     * 1) stats for participants 
     * 2) search participants
     */






    
    
}
