package com.springsecurityfull.jwt;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.common.net.HttpHeaders;

import io.jsonwebtoken.security.Keys;

@ConfigurationProperties(prefix="application.jwt")
@Component
public class JwtConfig {

	
	private String secretKey;
	private String tokenPrefix;
	private Integer tokenExpirationAfterDays;
	
	
	public JwtConfig() {
	
	}


	public String getSecretKey() {
		return secretKey;
	}


	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}


	public String getTokenPrefix() {
		return tokenPrefix;
	}


	public void setTokenPrefix(String tokenPrefix) {
		this.tokenPrefix = tokenPrefix;
	}


	public Integer getTokenExpirationAfterDays() {
		return tokenExpirationAfterDays;
	}


	public void setTokenExpirationAfterDays(Integer tokenExpirationAfterDays) {
		this.tokenExpirationAfterDays = tokenExpirationAfterDays;
	}
	
	public String getAuthorizationHeader() {
		return HttpHeaders.AUTHORIZATION;
	}
	
}
