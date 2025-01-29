package com.HotelService.RatingService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;
   @NotNull(message = "User id can not be empty or null")
    private Integer userId;
    @NotNull(message = "hotel Id can not be empty or null")
    private Integer hotelId;
    @NotNull(message = "Rating can not ne null or empty")
    private Integer rating;
    private String feedBack;
        public Rating() {
        }

        public Rating(Integer ratingId, Integer userId, Integer hotelId, Integer rating, String feedBack) {
            this.ratingId = ratingId;
            this.userId = userId;
            this.hotelId = hotelId;
            this.rating = rating;
            this.feedBack = feedBack;
        }

        public Integer getRatingId() {
            return ratingId;
        }

        public void setRatingId(Integer ratingId) {
            this.ratingId = ratingId;
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

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public String getFeedBack() {
            return feedBack;
        }

        public void setFeedBack(String feedBack) {
            this.feedBack = feedBack;
        }
    }