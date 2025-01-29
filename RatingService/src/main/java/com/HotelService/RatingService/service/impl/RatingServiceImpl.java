package com.HotelService.RatingService.service.impl;

import com.HotelService.RatingService.entity.Rating;
import com.HotelService.RatingService.repo.RatingRepository;
import com.HotelService.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getallRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> ratingByUserId(Integer userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> ratingBYHotelId(Integer hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public void deleteRatingById(Integer ratingId) {
            ratingRepository.deleteById(ratingId);
    }

    @Override
    public Rating updateRating(Integer id, Rating rating) {
        return null;
    }
}
