package com.ecommerce.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.backend.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	 Optional<Role> findByName(String name);
}
