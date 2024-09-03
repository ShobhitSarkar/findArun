package com.example.findarun.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class RunClub {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long runClubId;

    private String runClubName;
    private String runClubLocation;
    private int capacity;
    private String socialMedia;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;

    @ManyToMany(mappedBy = "runClubs")
    private List<Participant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "runClub")
    private List<Event> events = new ArrayList<>();


    /**
     * returns a list of creators associated with runclub
     * @return
     */
    public Creator getCreator(){
        return creator;
    }

    /**
     * allows to set a creator to a runclub
     * @param creator
     */
    public void setCreator (Creator creator){
        this.creator = creator;
    }

    /**
     * returns a list of all participants associated with the runclub
     * @return
     */
    public List<Participant> getParticipants(){
        return participants;
    }

    /**
     * allows to set a list of participants to a run club
     * @param participants
     */
    public void setParticipants(List<Participant> participants){
        this.participants = participants;
    }

    /**
     * returns a list of events associated with a runclub
     * @return
     */
    public List<Event> getEvents(){
        return events;
    }

    /**
     * sets a list of events asssociated with the runclub
     * @param events list of events 
     */
    public void setEvents(List<Event> events){
        this.events = events;
    }

    public Long getRunClubId() {
        return this.runClubId;
    }

    public void setRunClubId(Long runClubId) {
        this.runClubId = runClubId;
    }

    public String getRunClubName() {
        return this.runClubName;
    }

    public void setRunClubName(String runClubName) {
        this.runClubName = runClubName;
    }

    public String getRunClubLocation() {
        return this.runClubLocation;
    }

    public void setRunClubLocation(String runClubLocation) {
        this.runClubLocation = runClubLocation;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSocialMedia() {
        return this.socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

}
