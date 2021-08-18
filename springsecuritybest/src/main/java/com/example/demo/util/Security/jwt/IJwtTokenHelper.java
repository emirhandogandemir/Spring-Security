package com.example.demo.util.Security.jwt;

import java.util.Set;

import com.example.demo.domain.Role;
import com.example.demo.util.Security.AccessToken;
import com.example.demo.util.Security.SecretKey;

public interface IJwtTokenHelper {
	String generateJwtToken(SecretKey secretKey, String username, Set<Role> roles);// Bir tane token oluşturacağımız yapıdır

	boolean validateJwtToken(SecretKey secretKey, AccessToken accessToken); // bu tokenı doğrulama işlemlerini yapacağımız method

	String getUsernameFromJwtToken(SecretKey secretKey, AccessToken accessToken);// jwt tokenden subject ile usernamei almak
}
