package com.ecommerce.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  Optional<User> findByEmail(String email);

}
