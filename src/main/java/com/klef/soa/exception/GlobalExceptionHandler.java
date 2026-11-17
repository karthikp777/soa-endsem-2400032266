
package com.klef.soa.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<?> handleNotFound(
            TouristNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {

        return ResponseEntity.status(
                HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                    "error", "Internal Server Error"));
    }
}
