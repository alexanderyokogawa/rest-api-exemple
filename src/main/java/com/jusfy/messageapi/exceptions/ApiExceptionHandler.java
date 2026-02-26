package com.jusfy.messageapi.exceptions;

import com.jusfy.messageapi.dto.ApiErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<ApiErrorDto> handleMessageNotFoundException(MessageNotFoundException ex) {
        ApiErrorDto error = new ApiErrorDto(
            Instant.now().toString(),
            404,
            "Not Found",
            ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // trtar erro 400
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorDto> handleIllegalArgumentException(IllegalArgumentException ex) {
        ApiErrorDto error = new ApiErrorDto(
            Instant.now().toString(),
            400,
            "Bad Request",
            ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
