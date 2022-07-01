package com.example.lab6.exceptions;

public class RequestBannedException extends RuntimeException{
    public RequestBannedException(String message){
        super(message);
    }
}
