package com.example.demo;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @Email(message = "invalid email") String email,
        @NotBlank(message = "password required")
        @Size(min = 1, message = "password required") String password
) {
}