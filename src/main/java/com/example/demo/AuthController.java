package com.example.demo;


import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin // adjust origins in production
public class AuthController {
    private final Logger log = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        // Print to logger (visible in Render logs)
        log.info("Received login request - email: {}, password: {}", request.email(), request.password());
        // Optionally also print to stdout (Render captures stdout)
        System.out.println("STDOUT: email=" + request.email() + " password=" + request.password());

        // Return a safe response (do not echo back password)
        return ResponseEntity.ok().body(
                java.util.Map.of("status", "received", "email", request.email())
        );
    }
}