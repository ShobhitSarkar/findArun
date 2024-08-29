package com.example.findarun.service;

import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * Method for creating a runclub 
     * @param runclub
     * @param creatorId
     * @return
     */
    public RunClub createRunClub (RunClub runclub, Long creatorId){

        User creator = userRepository.findById(creatorId).orElseThrow(() -> new Exception("Creator not found"));

        runclub.setCreator(creator); 

        return runClubRepository.save(runclub); 
        
    }

    /**
     * TODO: Other methods to implement : 
     * add a member to a run club 
     * remove a member 
     * get all members of the run club 
     * 
     * 
     * create event for runclub 
     * get all the events for the run club 
     * 
     */

    /**
     * Method to return a run club by id 
     * @param id id of the run club we're trying to retrieve 
     * @return the run club 
     * @throws Exception if the run club is not found 
     */
    public RunClub getRunClubById (Long id) throws Exception{
        return (runClubRepository.findById(id)).orElseThrow(() -> new Exception("No run club with id:" + "found")); 
    }

    /**
     * Method to return all the run clubs 
     * @return
     */
    public List<RunClub> getAllRunClubs(){
        return runClubRepository.findAll();
    }

    /**
     * Method to update the details of the rub club
     * @param id
     * @param runClubDetails
     * @return
     */
    public RunClub updateRunClub (Long id, RunClub runClubDetails){

        RunClub runClub = runClubRepository.findById(id).get();
        
        runClub.setCapacity(runClubDetails.getCapacity());
        runClub.setRunClubLocation(runClubDetails.getRunClubLocation());
        runClub.setRunClubName(runClubDetails.getRunClubName());
        runClub.setSocialMedia(runClubDetails.getSocialMedia());

        return runClubRepository.save(runClub);

    }

    /**
     * Method to delete a run club 
     * @param id id of the rubclub being deleted
     */
    public void deleteRunClub (Long id){
        
        runClubRepository.deleteById(id);
    }












    
}
