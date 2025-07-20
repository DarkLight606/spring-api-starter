package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.ValidateUserRequest;
import com.codewithmosh.store.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Void> validateUser(
            @Valid @RequestBody ValidateUserRequest request
    ) {
        authService.validateUser(request.getEmail(), request.getPassword());
        return ResponseEntity.ok().build();
    }
}
