package com.api.hotelSpring.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuartoNotFoundException extends EntityNotFoundException{

    public QuartoNotFoundException (String message) {super(message);}
}
