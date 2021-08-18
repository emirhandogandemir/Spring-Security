package com.example.demo.util.Security;

import org.springframework.security.core.Authentication;

import com.example.demo.domain.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public interface ITokenProvider {
	   AccessToken createToken(String username, Set<Role> roles); // token 
	    boolean validateToken(AccessToken accessToken);
	    AccessToken getTokenFromHeader(HttpServletRequest httpServletRequest); // Başlıktan tokenı alıp kontrol etme bearere göre
	    Authentication getAuthentication(AccessToken accessToken);
}
