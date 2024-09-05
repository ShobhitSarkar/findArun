package com.example.findarun.service;

import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.findarun.model.Event;
import com.example.findarun.model.Participant;
import com.example.findarun.model.RunClub;
import com.example.findarun.model.User;
import com.example.findarun.repository.CreatorRepository;
import com.example.findarun.repository.EventRepository;
import com.example.findarun.repository.RunClubRepository;
import com.example.findarun.repository.UserRepository;

@Service
public class RunClubService {

    @Autowired 
    private RunClubRepository runClubRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    /**
     * Method to create a runClub
     * @param runClubDetails
     * @return
     */
    public RunClub createRunClub(RunClub runClubDetails) {
        
        return runClubRepository.save(runClubDetails);
    }

    /**
     * Method to return a single runclub using an id 
     * @param runClubId
     * @return
     */
    public RunClub getRunClub(Long runClubId) throws Exception{
        return runClubRepository.findById(runClubId).orElseThrow(() -> new Exception("No runclub with id" + runClubId + "found !"));
    }

    /**
     * Method to return all runClubs 
     * @return
     */
    public List<RunClub> getAllRunClubs() {
        return runClubRepository.findAll();
        
    }

    public RunClub updateRunClub(RunClub runClubDetails) throws Exception {
        RunClub existingClub; 
        try {
            existingClub = getRunClub(runClubDetails.getRunClubId());
        } catch (Exception e){
            throw new Exception("No runClub with the id found");
        } 
        existingClub.setRunClubName(runClubDetails.getRunClubName());
        existingClub.setRunClubLocation(runClubDetails.getRunClubLocation());
        existingClub.setCapacity(runClubDetails.getCapacity());
        existingClub.setSocialMedia(runClubDetails.getSocialMedia());

        return runClubRepository.save(existingClub);

        
    }

    /**
     * Method to delete a runClub
     * @param runClubId
     */
    public void deleteRunClub(Long runClubId) throws Exception {
        RunClub runClub; 
        
        try {
            runClub = getRunClub(runClubId); 
        } catch (Exception e){
            throw new Exception("No run club with id found !");
        }

        runClubRepository.deleteById(runClubId);
    }

    /**
     * Method to add a member to a runClub
     * @param runClubId
     * @param userId
     */
    public void addMember(Long runClubId, Long userId) throws Exception {
        
        RunClub runClub = getRunClub(runClubId); 

        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User with id : " + userId + "found!")); 

        runClub.getParticipants().add((Participant) user); 

        runClubRepository.save(runClub);



    }

    /**
     * Method to remove a member from a runClub
     * @param runClubId
     * @param userId
     */
    public void removeMember(Long runClubId, Long userId) throws Exception {
        
        RunClub runClub = getRunClub(runClubId); 

        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("No user with id: " + userId + "found !")); 

        runClub.getParticipants().remove(user); 

        runClubRepository.save(runClub);


    }

    /**
     * Get all the memebers of a runClub
     * @param runClubId
     * @return
     */
    public List<User> getAllRunClubMembers(Long runClubId) throws Exception {
        RunClub runClub; 
        
        try{
            runClub = getRunClub(runClubId); 
        } catch (Exception e){
            throw new Exception("No runclub with id" + runClubId + "found !");
        }

        return new ArrayList<>(runClub.getParticipants()); 
    }

    /**
     * Get all the events of the runClub
     * @param runClubId
     * @return
     */
    public List<Event> getAllRunClubEvents(Long runClubId) throws Exception {
        RunClub runClub; 
        
        try {
            runClub = getRunClub(runClubId);
        } catch (Exception e){
            throw new Exception ("No runclub with id: " + runClubId + "found");
        }

        return new ArrayList<>(runClub.getEvents());
    }

    /**
     * Create an event for a runClub
     * @param runClubId
     * @param event
     * @return
     */
    public Event createEventForRunClub(Long runClubId, Event event) throws Exception {
        RunClub runClub; 
        
        try {
            runClub = getRunClub(runClubId);
        } catch (Exception e){
            throw new Exception("Throw new exception"); 
        }

        event.setRunClub(runClub); 
        Event savedEvent = eventRepository.save(event); 
        runClub.getEvents().add(savedEvent); 
        runClubRepository.save(runClub); 

        return savedEvent;

        


        
    } 

    












    
}
