package com.example.findarun.service;

import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.findarun.model.Event;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRunClub'");
    }

    /**
     * Method to return a single runclub using an id 
     * @param runClubId
     * @return
     */
    public RunClub getRunClub(Long runClubId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRunClub'");
    }

    /**
     * Method to return all runClubs 
     * @return
     */
    public List<RunClub> getAllRunClubs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRunClubs'");
    }

    public RunClub updateRunClub(RunClub runClubDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRunClub'");
    }

    /**
     * Method to delete a runClub
     * @param runClubId
     */
    public void deleteRunClub(Long runClubId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRunClub'");
    }

    /**
     * Method to add a member to a runClub
     * @param runClubId
     * @param userId
     */
    public void addMember(Long runClubId, Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMember'");
    }

    /**
     * Method to remove a member from a runClub
     * @param runClubId
     * @param userId
     */
    public void removeMember(Long runClubId, Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMember'");
    }

    /**
     * Get all the memebers of a runClub
     * @param runClubId
     * @return
     */
    public List<User> getAllRunClubMembers(Long runClubId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRunClubMembers'");
    }

    /**
     * Get all the events of the runClub
     * @param runClubId
     * @return
     */
    public List<Event> getAllRunClubEvents(Long runClubId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRunClubEvents'");
    }

    /**
     * Create an event for a runClub
     * @param runClubId
     * @param event
     * @return
     */
    public Event createEventForRunClub(Long runClubId, Event event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEventForRunClub'");
    } 

    












    
}
