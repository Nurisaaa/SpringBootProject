package com.example.springbootproject.api;

import com.example.springbootproject.dto.request.AuthRequest;
import com.example.springbootproject.dto.responce.AuthResponse;
import com.example.springbootproject.service.serviceImpl.AuthServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/api/authentication")
@AllArgsConstructor
public class AuthApi {
    private final AuthServiceImpl authService;

    @PostMapping
    @PermitAll
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}
