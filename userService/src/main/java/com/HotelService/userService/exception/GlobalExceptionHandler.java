package com.HotelService.userService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundResource.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(NotFoundResource ex) {
        String message = ex.getMessage();

        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("success", true);
        response.put("status", HttpStatus.NOT_FOUND.value());  // Use int value of the HTTP status

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        StringBuilder errorMessage = new StringBuilder("Validation failed: ");
        result.getFieldErrors().forEach(error -> errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; "));
        return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
    }
}
