package com.example.findarun.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Participant extends User {

    @ManyToMany // participants can be members of multiple run clubs and run clubs can have multiple participants 
    @JoinTable(
        name="participant_runclub", 
        joinColumns = @JoinColumn(name = "participant_id"),
        inverseJoinColumns = @JoinColumn(name = "runclub_id")
    )
    private List<RunClub> runclubs = new ArrayList<>();

    @ManyToMany(mappedBy = "attendees") // participants can attend multiple events 
    private List<Event> eventsAttending = new ArrayList<>();

    public Participant(){}

    public Participant(User user){
        super(); 
        this.setUserId(user.getUserId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setPhoneNo(user.getPhoneNo());
        this.setLocation(user.getLocation());
        this.setSport(user.getSport());
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());
        this.setRole(UserRole.PARTICIPANT);
    }

    /**
     * returns a list of runclubs that the participant is part of 
     * @return
     */
    public List<RunClub> getRunClubs(){
        return runclubs;
    }

    /***
     * sets the run clubs a participant is part of 
     * @param runClubs
     */
    public void setRunClubs(List<RunClub> runClubs){
        this.runclubs = runClubs; 
    }

    /**
     * returns a list of events that the participant is atttending
     * @return
     */
    public List<Event> getEventsAttending(){
        return eventsAttending;
    }

    /**
     * allows to set a list of events that a participant can attend
     * @param eventsAttending
     */
    public void setEventsAttending(List<Event> eventsAttending){
        this.eventsAttending = eventsAttending; 
    }




    
}
