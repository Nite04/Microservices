package com.HotelService.userService.entities;

import lombok.*;


public class Rating {
    private Integer userId;
    private Integer hotelId;
    private String feedback;
    private Integer rating;
    private Integer ratingId;
    private Hotel hotel;

    public Rating() {
    }

    public Rating(Integer userId, Integer hotelId, String feedback, Integer rating, Integer ratingId, Hotel hotel) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.feedback = feedback;
        this.rating = rating;
        this.ratingId = ratingId;
        this.hotel = hotel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
