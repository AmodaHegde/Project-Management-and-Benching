package com.webknot.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webknot.users.model.Role;
import com.webknot.users.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
    
    Optional<User> findByUsername(String username);
    Optional<User> findByRole(Role role);

}
