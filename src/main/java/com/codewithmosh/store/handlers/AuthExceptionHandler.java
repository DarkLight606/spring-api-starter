package com.codewithmosh.store.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<Map<String, String>> handleUnauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                Map.of("error", "Unauthorized")
        );
    }
}
