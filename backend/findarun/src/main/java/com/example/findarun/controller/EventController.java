package com.example.findarun.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.findarun.model.Event;
import com.example.findarun.model.User;
import com.example.findarun.service.EventService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService; 

    /**
     * Post mapping to create an event associated with a runclub
     * @param event - event that we're trying to create
     * @param runclubId - runclub for which we're creating an event 
     * @return
     */
    @PostMapping("/createEvent/{runClubId}")
    public ResponseEntity<Event> createEvent(@RequestBody Event event, @PathVariable Long runclubId){

        Event createdEvent;

        try{
            createdEvent = eventService.createEvent(event, runclubId); 
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED); 
    }

    /**
     * Returns a single event 
     * @param id id of the event we're trying to retrieve 
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {

        Event event;

        try {
            event = eventService.getEventById(id); 
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(event);
    }

    /**
     * Returns a list of all the events 
     * @return the list of all events 
     */
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.getAllEvents(); 

        return ResponseEntity.ok(events);
    }

    /**
     * Put method to update the information about an event 
     * @param eventId - id of the event we're trying to update 
     * @param eventDetails - updated event details 
     * @return details of the updated event 
     */
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent (@PathVariable Long eventId, @RequestBody Event eventDetails){
        Event updatedEvent; 
        
        try {
            updatedEvent = eventService.updateEvent(eventId, eventDetails); 
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        return ResponseEntity.ok(updatedEvent);

    }

    /**
     * Delete method to delete an event
     * @param id - id of the event we're trying to delete 
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        
        return ResponseEntity.noContent().build(); 
    }

    /**
     * Get mapping to get events by runclub
     * @param runClubId
     * @return
     */
    @GetMapping("/runclub/{runClubId}")
    public ResponseEntity<List<Event>> getEventsByRunClub(@PathVariable Long runClubId) throws Exception{
        List<Event> events = eventService.getEventsByRunClub(runClubId);
        return ResponseEntity.ok(events);
    }

    /**
     * Post controller method to add an attendee to an event 
     * @param eventId - id of the event to which attendee needs to be added 
     * @param userId - id of the user attending the event 
     * @return
     */
    @PostMapping("/{eventId}/attend")
    public ResponseEntity<Void> attendEvent(@PathVariable Long eventId, @RequestParam Long userId ) throws Exception{
        eventService.addAttendee(eventId, userId); 
        return ResponseEntity.ok().build();
    }

    /**
     * Post controller to remove an attendee from the event 
     * @param eventId - id of the event for which we're removing an attendee 
     * @param userId - id of the user that is not going to be attending an event 
     * @return 
     */
    @PostMapping("/{eventId}/cancel")
    public ResponseEntity<Void> cancelAttendance (@PathVariable Long eventId, @RequestParam Long userId) throws Exception{
        eventService.removeAttendee(eventId, userId); 
        return ResponseEntity.ok().build();
    }

    /**
     * Controller to return a list of all the attendees for an event 
     * @param id - id of the event for which we need information 
     * @return
     */
    @GetMapping("/{eventId}/attendees")
    public ResponseEntity<List<User>> getEventAttendees (@PathVariable Long id) throws Exception{
        List<User> attendees = eventService.getEventAttendees(id); 

        return ResponseEntity.ok(attendees);
    }

    /**
     * TODO : Implement possible controllers : 
     * - Upcoming events 
     * - Search for events
     */

    
    





    
    
}
