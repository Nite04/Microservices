package com.HotelService.userService.controller;

import com.HotelService.userService.entities.User;
import com.HotelService.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        System.out.println("user name:" +user.getName());
        User user1 = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user1 = userService.getById(id);
        return ResponseEntity.ok(user1);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAll();
        return ResponseEntity.ok(allUser);
    }

    //for deleting
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId){
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    //for update

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser( @PathVariable Integer id , @RequestBody User user){
        User updatedUser = userService.updateUser(id,user);
        return ResponseEntity.ok(updatedUser);
    }
}
