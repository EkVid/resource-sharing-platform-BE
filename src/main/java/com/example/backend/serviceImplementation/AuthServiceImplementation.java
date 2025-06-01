package com.example.backend.serviceImplementation;

import com.example.backend.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService {

    @Override
    public boolean authenticate(String username, String password) {
        // check against DB and return true or false, return true for now
        return true;
    }
}
