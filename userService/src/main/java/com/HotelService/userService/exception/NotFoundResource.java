package com.HotelService.userService.exception;

public class NotFoundResource extends RuntimeException {
    public NotFoundResource(String msg) {
        super(msg);
    }
    public NotFoundResource(){
        super("No User Found !!");
    }
}
