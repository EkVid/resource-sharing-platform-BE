package com.example.backend.service;

public interface AuthService {
    boolean authenticate(String username, String password);
}
