package com.example.demo.service;

import com.example.demo.domain.dto.UserLoginDto;
import com.example.demo.domain.dto.UserRegisterDto;
import com.example.demo.util.Security.AccessToken;

public interface AuthService {
	AccessToken register(UserRegisterDto userRegisterDto);

	AccessToken login(UserLoginDto userLoginDto);
}
