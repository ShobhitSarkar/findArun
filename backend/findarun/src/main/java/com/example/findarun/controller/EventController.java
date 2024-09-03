package com.example.findarun.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.findarun.model.Event;
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

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.getAllEvents(); 

        return ResponseEntity.ok(events);
    }

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

    @DeleteMapping
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        
        return ResponseEntity.noContent().build(); 
    }

    
    
    





    
    
}
