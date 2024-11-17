package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.User;
import com.assignment.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; 
    }
    
    public String registerUser(String username, String password) {
        // Check if username is already taken
        if (userRepository.findByUsername(username) != null) {
            return "Username is already taken!";
        }

        // Create a new User
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        // Save the user to the database
        userRepository.save(newUser);

        return "Signup successful!";
    }

}
