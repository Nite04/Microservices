package com.HotelService.hotelService.controller;

import com.HotelService.hotelService.entity.Hotel;
import com.HotelService.hotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        System.out.println("user name:" +hotel.getName());
        Hotel  hotel1= hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> allUser = hotelService.getAllHotel();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Integer hotelId){
        Hotel hotel1 = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel1);
    }

    //for deleting
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer hotelId){
        hotelService.deleteHotelById(hotelId);
        return ResponseEntity.noContent().build();
    }

    //for update

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateUser( @PathVariable Integer id , @RequestBody Hotel hotel){
        Hotel updatedHotel = hotelService.updateHotel(id,hotel);
        return ResponseEntity.ok(updatedHotel);
    }
}
