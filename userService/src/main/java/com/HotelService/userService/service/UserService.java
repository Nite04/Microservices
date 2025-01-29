package com.HotelService.userService.service;

import com.HotelService.userService.entities.User;

import java.util.List;

public interface UserService {
     User save(User user);
     List<User> getAll();

     User getById(Integer userId);

     void deleteById(Integer userId);

     User updateUser(Integer id , User user);
}
