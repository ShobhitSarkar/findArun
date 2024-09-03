package com.example.findarun.model;

import java.util.*;

import java.time.LocalDateTime; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String name;
    private LocalDateTime date;
    private String location;
    private int capacity;
    private int currentAttendance;

   @ManyToOne
   @JoinColumn(name="runclub_id")
   private RunClub runClub; 

   @ManyToMany
   @JoinTable(
    name="event_attendees",
    joinColumns = @JoinColumn(name = "event_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id")
   )
   private List<User> attendees = new ArrayList<>();

   public List<User> getAttendees() {
       return this.attendees;
   }

   public void setAttendees(List<User> attendees) {
       this.attendees = attendees;
   }

    public Long getEventId() {
        return this.eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentAttendace() {
        return this.currentAttendance;
    }

    public void setCurrentAttendace(int currentAttendace) {
        this.currentAttendance = currentAttendace;
    }

}
