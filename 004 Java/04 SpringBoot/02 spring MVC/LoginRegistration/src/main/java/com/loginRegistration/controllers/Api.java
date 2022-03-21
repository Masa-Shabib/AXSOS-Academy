package com.loginRegistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loginRegistration.models.User;
import com.loginRegistration.services.UserService;

@RestController
public class Api {
	@Autowired
    private UserService userServ;
	
	@RequestMapping("/api/users")
	public List<User> allProducts(){
		return userServ.allUsers();
	}
	
	@RequestMapping(value="/api/users", method=RequestMethod.POST)
	public User createUser(User user) {
		return userServ.newUser(user);
	}
}
