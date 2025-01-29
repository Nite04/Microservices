package com.HotelService.userService.service.impl;

import com.HotelService.userService.entities.Hotel;
import com.HotelService.userService.entities.Rating;
import com.HotelService.userService.entities.User;
import com.HotelService.userService.exception.NotFoundResource;
import com.HotelService.userService.external.services.HotelService;
import com.HotelService.userService.external.services.RatingService;
import com.HotelService.userService.repo.UserRepository;
import com.HotelService.userService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RatingService ratingService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundResource("No user id found with this id: "+userId));
        //this is done via rest template
        // Rating[] ratingOfUser = restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+userId , Rating[].class);
        Rating[] ratingOfUser = ratingService.getValues(userId);
        logger.info("{}",ratingOfUser);

        List<Rating> listOfRating = Arrays.stream(ratingOfUser).toList();

        List<Rating> ratinglist = listOfRating.stream().map(rating -> {
            //api call to hotel service to get the hotel

            //As we are calling from feign client so commenting this rest template part of code ResponseEntity<Hotel> hotelEntity=restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+rating.getHotelId() , Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //logger.info("response status code: "  ,hotelEntity.getStatusCode());
            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRating(ratinglist);
        return user;
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.findById(userId).orElseThrow(()-> new NotFoundResource("user with given id is not found !! : " + userId));
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Integer id , @org.jetbrains.annotations.NotNull User user) {
        // Check if the user exists in the database
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundResource("No user found with this id to update: " + id));
        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getAbout() != null) {
            existingUser.setAbout(user.getAbout());
        }

        // Save the updated user to the database
        return userRepository.save(existingUser);
    }
}
