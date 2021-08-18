package com.springrolebasejwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springrolebasejwt.domain.Role;
import com.springrolebasejwt.domain.User;
import com.springrolebasejwt.service.UserService;

@SpringBootApplication
public class SpringrolebasedjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrolebasedjwtApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args ->{
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new User(null,"John Travolta","john","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Will Smith","will","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Emirhan Dogandemir","emirhan","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Seyit cici","seyit","1234",new ArrayList<>()));
			
			userService.addRoleTouser("john","ROLE_USER");
			userService.addRoleTouser("john","ROLE_MANAGER");
			userService.addRoleTouser("will","ROLE_MANAGER");
			userService.addRoleTouser("emirhan","ROLE_ADMIN");
			userService.addRoleTouser("seyit","ROLE_USER");
			userService.addRoleTouser("seyit","ROLE_ADMIN");
			userService.addRoleTouser("seyit","ROLE_SUPER_ADMIN");
		};
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
