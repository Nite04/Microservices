package com.HotelService.RatingService.controller;

import com.HotelService.RatingService.entity.Rating;
import com.HotelService.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/save")
    public ResponseEntity<Rating>create(@RequestBody Rating rating){
        Rating rating1 = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }
    @GetMapping("/all")
        public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getallRating());
        }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Rating>>getUserRating(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.ratingByUserId(id));

    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Rating>>getHotelRating(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.ratingBYHotelId(id));

    }


}
