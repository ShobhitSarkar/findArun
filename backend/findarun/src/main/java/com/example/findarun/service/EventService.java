package com.example.findarun.service;

import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.findarun.model.Event;
import com.example.findarun.model.RunClub;
import com.example.findarun.repository.EventRepository;
import com.example.findarun.repository.RunClubRepository;
import com.example.findarun.repository.UserRepository;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository; 

    @Autowired
    RunClubRepository runClubRepository; 

    
    /**
     * Method to create an event 
     * @param event - information about the event 
     * @param runClubId - 
     * @return
     * @throws Exception
     */
    public Event createEvent(Event event, Long runClubId) throws Exception{
        
        RunClub runClub = runClubRepository.findById(runClubId).orElseThrow(() -> new Exception("No runclub found with id: " + runClubId));

        event.setRunClub(runClub); 

        return eventRepository.save(event); 
    
    }

    /**
     * Method to return all the events 
     * @return all the events 
     */
    public List<Event> getAllEvents(){
        return eventRepository.findAll(); 
    }

    /**
     * Method to return a single event
     * @param id id of the event we're trying to find 
     * @return the event 
     * @throws Exception if event not found 
     */
    public Event getEventById(Long id) throws Exception{
        return(eventRepository.findById(id)).orElseThrow(() -> new Exception("No run event found with id + " + id));
    }

    /**
     * Method to update the details of an event
     * @param eventId id of the event we're trying to update 
     * @param updatedEvent the details of the event 
     * @return the updated event 
     * @throws Exception if the event is not found 
     */
    public Event updateEvent(Long eventId, Event updatedEvent) throws Exception{
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new Exception("No event with id : " + eventId + "found."));

        event.setCapacity(updatedEvent.getCapacity());
        event.setCurrentAttendace(updatedEvent.getCurrentAttendace());
        event.setDate(updatedEvent.getDate());
        event.setLocation(updatedEvent.getLocation());
        event.setName(updatedEvent.getName());

        return eventRepository.save(event);

    }
    
    /**
     * Method to delete an event 
     * @param eventId deletes an event 
     */
    public void deleteEvent(Long eventId){
        eventRepository.deleteById(eventId);
    }
    
}
