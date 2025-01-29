package com.HotelService.hotelService.service.impl;

import com.HotelService.hotelService.entity.Hotel;
import com.HotelService.hotelService.exception.NotFoundObjectException;
import com.HotelService.hotelService.repo.HotelRepository;
import com.HotelService.hotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new NotFoundObjectException("No hotel found with this id:" + id));
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotel(Integer id, Hotel hotel) {
        return null;
    }

    @Override
    public void deleteHotelById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new NotFoundObjectException("No hotel found with this id:" + id));
        hotelRepository.delete(hotel);
    }
}
