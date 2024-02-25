package com.laguna.videogames.videogames.auth;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String password;
}
