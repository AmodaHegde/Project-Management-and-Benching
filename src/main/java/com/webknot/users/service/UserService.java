package com.webknot.users.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webknot.users.model.Role;
import com.webknot.users.model.User;
import com.webknot.users.repository.UserRepo;

@Service
public class UserService{
    
    @Autowired
    private UserRepo mySqlRepo;

    private Role role;
   
    public UserService(UserRepo mySqlRepo) {
        this.mySqlRepo = mySqlRepo;
        // this.jwtService = jwtService;
        // this.commonService = commonService;
        }

    public User register(User request){

        // PasswordEncoder passwordEncoder = commonService.getPasswordEncoder()
        
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        role = request.getRole();
        Optional<User> existingAdmin = mySqlRepo.findByRole(Role.ADMIN);
        if(existingAdmin.isPresent() && role == Role.ADMIN){
            role = Role.USER;
            user.setRole(role);
        }
        else{
            role = Role.ADMIN;
            user.setRole(role);
        }
        // String token = jwtService.generateToken(user);
        return mySqlRepo.save(user);

    }

    public boolean authenticate(User request){

        // AuthenticationManager authenticationManager = commonService.getAuthenticationManager();

        // authenticationManager.authenticate(
        //     new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
        // );
        User user = mySqlRepo.findByUsername(request.getUsername()).get();
        if(user!=null){
            return user.getPassword().equals(request.getPassword());
        }
        // String token = jwtService.generateToken(user);
        return false;

    }

    public List<User> getAllUsers(){
        
        return mySqlRepo.findAll();
    }

    public User getUserById(Long id){
        return mySqlRepo.findById(id).get();
    }
}
