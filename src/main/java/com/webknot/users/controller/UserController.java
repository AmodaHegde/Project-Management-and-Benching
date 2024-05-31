package com.webknot.users.controller;
import com.webknot.users.model.User;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webknot.users.service.UserService;

@RestController
public class UserController {
 
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public User register(@RequestBody User request){
        return userService.register(request);
    }

    @PostMapping("/user/login")
    public boolean login(@RequestBody User request) {
        return userService.authenticate(request);
    }

    @GetMapping("/user/get-all-users")
    public List<User> getAllUsers(){
         return userService.getAllUsers();
    }

    @GetMapping("/user/get-user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    // @DeleteMapping("/remove-user/{id}")
    // public boolean deleteUser(@PathVariable("id") Integer id){
    //     return userService.deleteUser(id);
    // }

    // @PutMapping("/update-user/{id}")
    // public User updateUser(@PathVariable("id") Integer id, @RequestBody Map<String, String> body){
    //     return userService.updateUser(id, body);
    // }
}
