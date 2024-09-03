package com.example.findarun.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.findarun.model.Creator;
import com.example.findarun.model.User;
import com.example.findarun.model.UserRole;
import com.example.findarun.repository.EventRepository;
import com.example.findarun.repository.RunClubRepository;
import com.example.findarun.repository.UserRepository;

@Service
public class CreatorService {

    @Autowired
    UserRepository userRepository; 

    @Autowired
    RunClubRepository runClubRepository; 

    @Autowired
    EventRepository eventRepository; 

    /**
     * Method for creating a creator 
     * @param user - 
     * @return
     */
    public Creator createCreator (User user){
        if (user.getRole() == UserRole.CREATOR){
            throw new Exception("User is already a creator !")
        }

        Creator creator = new Creator(user);
        creator.setRole(UserRole.CREATOR); 
        return userRepository.save(creator);

    }

    /**
     * Returns a creator by Id 
     * @param creatorId id of the creator we're looking for 
     * @return the user 
     * @throws Exception if the creator is not found 
     */
    public Creator getCreatorById(Long creatorId) throws Exception {

        return userRepository.findById(creatorId)
            .filter(user -> user instanceof Creator)
            .map(user -> (Creator) user)
            .orElseThrow(() -> new Exception("Creator not found"));
    }

    /**
     * Method to return all the creators 
     * @return returns a list with all the creators 
     */
    public List<Creator> getAllCreators() {
        return userRepository.findAllByRole(UserRole.CREATOR)
            .stream()
            .map(user -> (Creator) user)
            .collect(Collectors.toList());
    }

    // TODO: update creator 

    

    /**
     * Demoting a creator to participant in case we need to delete it 
     * @param creatorId
     */
    public void deleteCreator (Long creatorId) throws Exception{

        Creator creator;

        try {
            creator = getCreatorById(creatorId); 
        } catch (Exception e) {
            throw new Exception("No creator with id:" + creatorId + "found.");
        }
        creator.setRole(UserRole.PARTICIPANT);

        userRepository.save(creator);
    }

    public Creator updateCreator(Long creatorId, Creator creatorDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCreator'");
    }





    
}
