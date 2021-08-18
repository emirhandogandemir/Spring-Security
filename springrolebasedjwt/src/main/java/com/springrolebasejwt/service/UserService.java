package com.springrolebasejwt.service;

import java.util.List;

import com.springrolebasejwt.domain.Role;
import com.springrolebasejwt.domain.User;

public interface UserService {

	User saveUser(User user);
	
	Role saveRole(Role role);
	
	void addRoleTouser(String userName,String roleName);
	
	User getUser(String username);
	
	List<User> getUsers();
}
