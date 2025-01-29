package com.HotelService.RatingService.repo;

import com.HotelService.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    List<Rating> findByUserId(Integer userId);
    List<Rating> findByHotelId(Integer hotelId);
}
