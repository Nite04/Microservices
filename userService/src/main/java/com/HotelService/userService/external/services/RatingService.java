package com.HotelService.userService.external.services;

import com.HotelService.userService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    //get
    @GetMapping ("/rating/user/{userId}")
    Rating[] getValues(@PathVariable Integer userId);
    @PostMapping("/rating/save")
    public Rating createRating(Rating values);

    //post

    //put
}
