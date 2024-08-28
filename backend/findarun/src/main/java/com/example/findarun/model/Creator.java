package com.example.findarun.model;

import jakarta.persistence.Entity;

@Entity
public class Creator extends User {

    private String socialMedia;

    // TODO: Figure out relationships between RunClub and Event. 

    public String getSocialMedia() {
        return this.socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    
}
