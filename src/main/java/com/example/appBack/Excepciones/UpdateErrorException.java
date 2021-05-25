package com.example.appBack.Excepciones;

public class UpdateErrorException extends RuntimeException{

    public UpdateErrorException(String message) {
        super(message);
    }
}
