package com.example.lab6;

import com.example.lab6.model.LoginRequest;
import com.example.lab6.model.LoginResponse;
import com.example.lab6.model.RefreshToken;
import com.example.lab6.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshToken refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}
