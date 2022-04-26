package com.in.cinema.user.controller;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {Exception.class, IllegalArgumentException.class})
    public ResponseEntity<Map> handleException(Exception e) {

        return new ResponseEntity(Map.of("errorMessage", e.getLocalizedMessage()), HttpStatus.UNPROCESSABLE_ENTITY);

    }
}
