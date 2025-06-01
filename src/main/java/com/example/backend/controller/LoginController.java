package com.example.backend.controller;


import com.example.backend.model.LoginRequest;
import com.example.backend.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final AuthService authService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    // POST Request to log in (/login)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        boolean success = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        logger.info("Checking...");

        if(success){
            logger.info("Login successful for user");
            return ResponseEntity.ok("Login successful!");
        } else {
            logger.info("Failed...");
            return ResponseEntity.status(401).body("Invalid usernamne or password");
        }
    }
 }
