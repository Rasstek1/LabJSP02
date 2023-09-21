package com.martin.labjsp02.labjsp02.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public String handleResponseStatusException(HttpServletRequest request, ResponseStatusException ex) {
        request.setAttribute("javax.servlet.error.status_code", ex.getStatusCode().value());
        request.setAttribute("javax.servlet.error.message", ex.getReason());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleAllExceptions(HttpServletRequest request, Exception ex) {
        request.setAttribute("javax.servlet.error.status_code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        request.setAttribute("javax.servlet.error.message", ex.getMessage());
        return "error";
    }

}


