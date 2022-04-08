package com.example.springbootproject.service.serviceImpl;

import com.example.springbootproject.dto.request.AuthRequest;
import com.example.springbootproject.dto.responce.AuthResponse;
import com.example.springbootproject.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authentication;

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));

        String generatedToken = jwtUtils.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setEmail(authRequest.getEmail());
        authResponse.setToken(generatedToken);
        return authResponse;
    }
}
