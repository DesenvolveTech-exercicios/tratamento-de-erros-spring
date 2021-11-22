package com.DesenvolveTech.ExercicioExceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DogsNotFoundException extends RuntimeException {
    public DogsNotFoundException(String message) {
        super(message);
    }
}