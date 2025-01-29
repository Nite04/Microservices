package com.HotelService.userService.external.services;

import com.HotelService.userService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {
    @GetMapping("/hotel/{hotelId}")
    Hotel getHotel(@PathVariable Integer hotelId);
}
