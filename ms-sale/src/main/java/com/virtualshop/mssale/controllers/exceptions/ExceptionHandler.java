package com.virtualshop.mssale.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.virtualshop.mssale.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ExceptionShape> resourceNotFound(HttpServletRequest request, ResourceNotFoundException resourceNotFoundException) {
        
        String errorMessage = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionShape exceptionShape = new ExceptionShape(Instant.now(), status.value(), resourceNotFoundException.getMessage(), errorMessage, request.getRequestURI());
        return ResponseEntity.status(status.value()).body(exceptionShape);
    }
} 