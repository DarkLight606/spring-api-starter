package com.codewithmosh.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ValidateUserRequest {
    @NotBlank
    @Email
    String email;
    @NotBlank
    String password;
}
