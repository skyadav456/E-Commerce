package com.ecommerce.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.model.User;
import com.ecommerce.backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	  public ResponseEntity<User> registerUser(@RequestBody User user) {
	        User savedUser = service.registerUser(user);
	        return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	    }
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = service.findAllUsers();
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
}
