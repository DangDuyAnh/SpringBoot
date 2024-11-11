package com.example.dataconnect.controller;

import com.example.dataconnect.jwt.JwtTokenProvider;
import com.example.dataconnect.payload.LoginRequest;
import com.example.dataconnect.payload.LoginResponse;
import com.example.dataconnect.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

//    @PostMapping("")
//    public void test(){
//        System.out.println("Hi");
//    }

    @GetMapping("")
    public void test2(){
        System.out.println("Hi");
    }

    @PostMapping("")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    // Xác thực từ username và password.
        System.out.println("Hi");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        System.out.println(jwt);
        return new LoginResponse(jwt);
    }
}

