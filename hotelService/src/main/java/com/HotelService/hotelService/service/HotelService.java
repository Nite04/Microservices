package com.HotelService.hotelService.service;

import com.HotelService.hotelService.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);
    Hotel getHotelById(Integer id);
    List<Hotel> getAllHotel();
    Hotel updateHotel(Integer id , Hotel hotel);
    void deleteHotelById(Integer id);
}
