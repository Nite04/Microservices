package com.HotelService.hotelService.exception;

public class NotFoundObjectException extends RuntimeException{
    public NotFoundObjectException(String msg){
        super(msg);
    }
    public NotFoundObjectException(){
        super("No Hotel Found ");
    }
}
