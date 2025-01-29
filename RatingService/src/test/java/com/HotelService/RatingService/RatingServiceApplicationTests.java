package com.HotelService.RatingService;

import com.HotelService.RatingService.entity.Rating;
import com.HotelService.RatingService.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RatingServiceApplicationTests {


	@Test
	void contextLoads() {
	}
	@Autowired
	private RatingService ratingService;
	@Test void createRating(){
		Rating rating = new Rating( 5, 9 , 3, 7,"Good Hotel");
		Rating saveRating = ratingService.create(rating);

		System.out.println("new Rating created");
	}

}
