package com.example.findarun.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.findarun.repository.UserRepository;
import com.example.findarun.service.UserService;
import com.example.findarun.model.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;




@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired 
    private UserService userService;

    /**
     * Get mapping to return all the users 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * Get mapping to return a single user
     * @param id id of the user we're retrieving
     * @return a single user 
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getByUserId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Post mapping to create a user 
     * @param user
     * @return
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user); 
        return ResponseEntity.created(URI.create("api/users/" + createdUser.getUserId())).body(createdUser);
    }

    /**
     * Put mapping to create a new user 
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        try{
            User updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete Mapping to delete a user
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Post mapping to update password 
     * @param id id of the user being changed 
     * @param passwordData map of old password, new password 
     * @return 
     */
    @PostMapping("/{id}/change-password")
    public ResponseEntity<Void> changePassword(@PathVariable Long id, @RequestBody Map <String, String> passwordData) {
        
        String oldPassword = passwordData.get("oldPassword"); 
        String newPassword = passwordData.get("newPassword"); 

        if (oldPassword == null || newPassword == null){
            return ResponseEntity.badRequest().build();
        }

        try {
            boolean changed = userService.changePassword(id, oldPassword, newPassword);
            
            if (changed){
                return ResponseEntity.noContent().build();
            } else{
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get method for search user by name 
     * @param name name of the user we're trying to find
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String name) {
        List<User> users = userService.searchUserByName(name); 

        return ResponseEntity.ok(users);
    }

    /**
     * Put mapping to promote participant to creator 
     * @param id id of the participant we're trying to promote
     * @return
     */
    @PutMapping("/{id}/promote")
    public ResponseEntity<User> promoteToCreator(@PathVariable Long id) {
        try {
            User promotedUser = userService.promoteToCreator(id);
            return ResponseEntity.ok(promotedUser);
        } catch (Exception e) {
            if (e.getMessage().contains("User not found")) {
                return ResponseEntity.notFound().build();
            } else if (e.getMessage().contains("already a creator")) {
                return ResponseEntity.badRequest().body(null);
            } else {
                return ResponseEntity.internalServerError().build();
            }
        }
    }

    /**
     * TODO: Implement search user by location, user statistics
     */


    
    
    
    


    
    

    

    
    
    
}
