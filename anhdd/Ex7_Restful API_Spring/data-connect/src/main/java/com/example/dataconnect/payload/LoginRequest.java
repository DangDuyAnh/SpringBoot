package com.example.dataconnect.payload;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @NotBlank
    private String username;

    public LoginRequest() {
    }

    @NotBlank
    private String password;
}
