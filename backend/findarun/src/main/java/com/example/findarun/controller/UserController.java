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


    
    

    

    
    
    
}
