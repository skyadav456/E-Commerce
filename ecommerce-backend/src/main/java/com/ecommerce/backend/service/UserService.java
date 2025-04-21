package com.ecommerce.backend.service;

import java.util.List;

import com.ecommerce.backend.model.User;

public interface UserService {
	User registerUser(User user);
	List<User> findAllUsers();

}
