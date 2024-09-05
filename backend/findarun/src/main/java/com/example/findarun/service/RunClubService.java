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

    public RunClub createRunClub(RunClub runClubDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRunClub'");
    }

    public RunClub getRunClub(Long runClubId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRunClub'");
    }

    public List<RunClub> getAllRunClubs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRunClubs'");
    }

    public RunClub updateRunClub(RunClub runClubDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRunClub'");
    }

    public void deleteRunClub(Long runClubId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRunClub'");
    }

    public void addMember(Long runClubId, Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMember'");
    }

    public void removeMember(Long runClubId, Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMember'");
    }

    public List<User> getAllRunClubMembers(Long runClubId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRunClubMembers'");
    }

    public List<Event> getAllRunClubEvents(Long runClubId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRunClubEvents'");
    }

    public Event createEventForRunClub(Long runClubId, Event event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEventForRunClub'");
    } 

    












    
}
