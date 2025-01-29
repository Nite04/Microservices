package com.HotelService.RatingService.service;

import com.HotelService.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);
    List<Rating> getallRating();
    List<Rating> ratingByUserId(Integer userId);
    List<Rating> ratingBYHotelId(Integer hotelId);
    void deleteRatingById(Integer ratingId);
    Rating updateRating(Integer id, Rating rating);

}
