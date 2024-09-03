package com.example.findarun.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Creator extends User {

    private String socialMedia;

    @OneToMany(mappedBy = "creator") //one creator can be linked to multiple run clubs 
    private List<RunClub> runClubs = new ArrayList<>();

    @ManyToMany // creators can attend multiple events can have multiple attendees 
    private List<Event> eventsAttending = new ArrayList<>();

    public Creator(User user) {}

    public Creator(User user){
        super(); 
        this.setUserId(getUserId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setPhoneNo(user.getPhoneNo());
        this.setLocation(user.getLocation());
        this.setSport(user.getSport()); 
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());
        this.setRole(UserRole.CREATOR);
    }

    /**
     * Get all the run clubs that the creator is associated with 
     * @return a list of runclubs 
     */
    public List<RunClub> getRunClubs(){
        return runClubs;
    }

    /**
     * Set or associate run clubs with a particular creator 
     * @param runClubs
     */
    public void setRunClubs(List<RunClub> runClubs){
        this.runClubs = runClubs; 
    }

    /**
     * returns a list of events that the creator is attending
     * @return
     */
    public List<Event> getEventsAttending(){
        return eventsAttending;
    }

    /**
     * returns sets a list of events that the creator is attending 
     * @param eventsAttending - all the events that the creator needs to attend 
     */
    public void setEventsAttending(List<Event> eventsAttending){
        this.eventsAttending = eventsAttending;
    }

    public String getSocialMedia() {
        return this.socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    
}
