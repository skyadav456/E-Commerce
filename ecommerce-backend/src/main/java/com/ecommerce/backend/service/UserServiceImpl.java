package com.ecommerce.backend.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.model.Role;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.RoleRepository;
import com.ecommerce.backend.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service

public class UserServiceImpl implements UserService {

	  @Autowired
	    private UserRepository userRepo;
	    @Autowired
	    private RoleRepository roleRepo;
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	public User registerUser(User user) {
			//Encode password
		user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Assign default role
        Role role = roleRepo.findByName("ROLE_USER")
                .orElseGet(() -> roleRepo.save(new Role(null, "ROLE_USER")));
        user.setRoles(new HashSet<>(List.of(role)));
        return userRepo.save(user);	}

	@Override
	public List<User> findAllUsers() {
		  return userRepo.findAll();
	}

	

}
