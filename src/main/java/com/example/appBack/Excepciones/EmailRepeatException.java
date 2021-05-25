package com.example.appBack.Excepciones;

public class EmailRepeatException extends RuntimeException{
    public EmailRepeatException(String message) {
        super(message);
    }
}
