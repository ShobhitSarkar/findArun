package com.example.findarun.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RunClub {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long runClubId;

    private String runClubName;
    private String runClubLocation;
    private int capacity;
    private String socialMedia;

    public Long getRunClubId() {
        return this.runClubId;
    }

    public void setRunClubId(Long runClubId) {
        this.runClubId = runClubId;
    }

    public String getRunClubName() {
        return this.runClubName;
    }

    public void setRunClubName(String runClubName) {
        this.runClubName = runClubName;
    }

    public String getRunClubLocation() {
        return this.runClubLocation;
    }

    public void setRunClubLocation(String runClubLocation) {
        this.runClubLocation = runClubLocation;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSocialMedia() {
        return this.socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

}
