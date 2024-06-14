package com.springboot.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.users.model.Role;
import com.springboot.users.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
    
    Optional<User> findByUsername(String username);
    Optional<User> findByRole(Role role);

}
