package com.HotelService.userService.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotEmpty(message = "Name cannot be null or empty")
    private String name;
    @NotEmpty(message = "Email cannot be null or empty")
    private String email;
    @NotEmpty(message = "About cannot be null or empty")
    private String about;
    @Transient
    private List<Rating> rating;

    public User() {
    }

    public User(Integer userId, String name, String email, String about, List<Rating> rating) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.about = about;
        this.rating = rating;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }
}
