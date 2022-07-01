package com.example.lab6.service;

import com.example.lab6.model.LoginRequest;
import com.example.lab6.model.LoginResponse;
import com.example.lab6.model.RefreshToken;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshToken refreshTokenRequest);
}
