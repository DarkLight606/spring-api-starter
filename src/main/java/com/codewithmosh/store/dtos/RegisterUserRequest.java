package com.codewithmosh.store.dtos;

import com.codewithmosh.store.validation.Lowercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    @NotBlank
    @Email(message = "Email must be valid")
    @Lowercase(message = "email must be in lowercase")
    private String email;

    @NotBlank
    @Size(min = 6, max = 25, message = "Password must be between 6 to 25 characters long")
    private String password;
}
