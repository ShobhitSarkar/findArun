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

    /**
     * Post method for creating a participant 
     * @param newParticipant - details of the new participant 
     * @return
     */
    @PostMapping
    public ResponseEntity<Participant> createParticipant (@RequestBody Participant newParticipant){
        Participant participant = new Participant(newParticipant);

        return ResponseEntity.ok(participant);
    }

    /**
     * Retrieve a single participant 
     * @param participantId - id of the participant we're trying to retrieve 
     * @return a single participant 
     */
    @GetMapping("/participantId}")
    public ResponseEntity<Participant> getParticipant (@PathVariable Long participantId){
        Participant participant = participantService.getSingleParticipant(participantId); 
        
        return ResponseEntity.ok(participant); 
    }

    /**
     * Retrieve all the participants 
     * @return a list of all the participants 
     */
    @GetMapping
    public ResponseEntity<List<Participant>> getAllParticipants(){
        List<Participant> participants = participantService.getAllParticipants(); 

        return ResponseEntity.ok(participants);
    }

    /**
     * Update a participant 
     * @param participantId - id of the participant we're updating 
     * @param updatedParticipant - details of the participant 
     * @return - updated participant 
     */
    @PutMapping("/{participantId}")
    public ResponseEntity<Participant> updateParticipant (@PathVariable Long participantId, @RequestBody Participant updatedParticipant){

        Participant participant = participantService.updateParticipant(participantId, updatedParticipant); 

        return ResponseEntity.ok(participant);

    }

    /**
     * Delete a partcipant 
     * @param participantId - id of the participant we're deleting 
     * @return
     */
    @DeleteMapping("/{participantId}")
    public ResponseEntity<Void> deleteParticipant (@PathVariable Long participantId){
        
        participantService.deleteParticipant(participantId); 

        return ResponseEntity.noContent().build();
    }

    /**
     * For a participant to join a runClub
     * @param participantId - id of the participant trying to join 
     * @param runClubId - id of the runclub the participant is joining 
     * @return - void 
     */
    @PostMapping("/{participantId}/join/{runClubId}")
    public ResponseEntity<Void> joinRunClub (@PathVariable Long participantId, @PathVariable Long runClubId){

        participantService.joinRunClub(participantId, runClubId); 

        return ResponseEntity.noContent().build(); 
    }

    /**
     * For a participant to leave a runClub
     * @param participantId - id of the participant trying to join 
     * @param runClubId - id of the runclub being joined 
     * @return - nothing 
     */
    @PostMapping("/{participantId}/leave/{runClubId}")
    public ResponseEntity<Void> leaveRunClub (@PathVariable Long participantId, @PathVariable Long runClubId){

        participantService.leaveRunClub(participantId, runClubId); 

        return ResponseEntity.noContent().build();
    }

    /**
     * Get all the runclubs the participant is part of 
     * @param participantId - id of the participant we need information for 
     * @return a list of runclubs 
     */
    @GetMapping("/{participantId}/runClubs")
    public ResponseEntity<List<RunClub>> getParticipantRunClubs (@PathVariable Long participantId){
        
        List<RunClub> runClubs = participantService.getRunClubs(participantId); 

        return ResponseEntity.ok(runClubs);
    }

    /**
     * method for a participant to register for an event 
     * @param participantId - id of the participant trying to join
     * @param eventId - id of the event to join
     * @return nothin 
     */
    @PutMapping("/{participantId}/register/{eventId}")
    public ResponseEntity<Void> joinEvent (@PathVariable Long participantId, @PathVariable Long eventId){

        participantService.joinEvent(participantId, eventId); 

        return ResponseEntity.noContent().build();
    }

    /**
     * method for the participant to unregister for an event 
     * @param pariticpantId - id of the participant trying to leave
     * @param eventId - id of the event the participant is trying to leave 
     * @return nothing 
     */
    @PutMapping("/{participantId}/unregister/{eventId}")
    public ResponseEntity<Void> leaveEvent (@PathVariable Long pariticpantId, @PathVariable Long eventId){

        participantService.leaveEvent(pariticpantId, eventId); 

        return ResponseEntity.noContent().build(); 
    }

    /**
     * method for getting all the events the person is participating in 
     * @param participantId - id of the participant we need information for
     * @return : nothing 
     */
    @GetMapping("/{participantId}/events")
    public ResponseEntity<Void> joinEvent (@PathVariable Long participantId){

        participantService.getParticipantEvents(participantId); 

        return ResponseEntity.noContent().build(); 
    }

    /**
     * TODO: Additional things to add : 
     * 1) stats for participants 
     * 2) search participants
     */






    
    
}
