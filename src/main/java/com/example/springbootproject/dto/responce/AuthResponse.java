package com.example.springbootproject.dto.responce;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthResponse {
    private String email;
    private String token;
}
