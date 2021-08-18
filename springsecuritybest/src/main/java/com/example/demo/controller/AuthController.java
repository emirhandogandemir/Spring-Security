package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.dto.UserLoginDto;
import com.example.demo.domain.dto.UserRegisterDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import com.example.demo.util.Security.AccessToken;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AccessToken> register(@RequestBody UserRegisterDto userRegisterDto) {
        AccessToken accessToken =  authService.register(userRegisterDto);
        return ResponseEntity.ok(accessToken);

    }
    @PostMapping("/login")
    public ResponseEntity<AccessToken> login(@RequestBody UserLoginDto userLoginDto) {
        AccessToken accessToken = authService.login(userLoginDto);
        return ResponseEntity.ok(accessToken);
    }




}
