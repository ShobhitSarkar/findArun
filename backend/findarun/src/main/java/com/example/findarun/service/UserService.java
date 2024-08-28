package com.example.findarun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.findarun.model.User;
import com.example.findarun.repository.UserRepository;
import java.util.Optional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Method to return a single user
     * @param id - id of the user
     * @return user 
     */
    public Optional<User> getByUserId(Long id){
        return userRepository.findById(id);
    }

    /**
     * Method to return all the users 
     * @return all users
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Method to update user information, doesn't update username and password here.
     * @param id id of the user
     * @param updatedUser updated information
     * @return updated user 
     */
    public User updateUser(Long id, User updatedUser){
        
        return userRepository.findById(id).map(user -> {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setPhoneNo(updatedUser.getPhoneNo());
            user.setLocation(updatedUser.getLocation());
            user.setSport(updatedUser.getSport());
            user.setUserType(updatedUser.getUserType());
        }).orElseThrow(() -> new Excpetion("User not found"));
    }

    /**
     * Method to delete a user
     * @param id id of the user beinbg deleted
     * @throws Exception
     */
    public void deleteUser(Long id) throws Exception{
        if (!userRepository.existsById(id)){
            throw new Exception("User not found " + id);
        }

        userRepository.deleteById(id);
    }

    /**
     * Method to change the password of the user 
     * @param userId - user for which we need to change
     * @param oldPassword - old password 
     * @param newPassword - new password 
     * @return - True if successful, false otherwise.
     */
    public boolean changePassword(Long userId, String oldPassword, String newPassword) {
        return userRepository.findById(userId)
            .map(user -> {
                if (passwordEncoder.matches(oldPassword, user.getPassword())) {
                    user.setPassword(passwordEncoder.encode(newPassword));
                    userRepository.save(user);
                    return true;
                }
                return false;
            })
            .orElse(false);
    }

    /**
     * Method to search the users by name
     * @param name - name of the person being searchd
     * @return - user
     */
    public User searchUserByName(String name){
        return userRepository.findByFirstNameContainingOrLastNameContaining(name, name);
    }
    
    /**
     * TODO 
     * Promote from participant to creator
     * @param userId - user being promoted
     * @return
     */
    public boolean promoteToCreator (Long userId){

        return false;
    }








    
}
