package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	
	private final UserRepository userRepository;

	public UserService(UserRepository repo) {
		super();
		this.userRepository = repo;
	}
	
	  public User registerUser(User user) {
	        return userRepository.save(user);
	    }

	    // Get all users
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    // Get user by ID
	    public User getUserById(Long id) {
	        return userRepository.findById(id).orElse(null);
	    }

	    public User loginUser(String email, String password) {

	        System.out.println("Login Email: " + email);
	        System.out.println("Login Password: " + password);

	        User user =
	                userRepository.findByEmailAndPassword(
	                        email,
	                        password
	                );

	        if (user == null) {

	            System.out.println("USER NOT FOUND");

	            throw new RuntimeException(
	                    "Invalid email or password"
	            );
	        }

	        System.out.println("USER FOUND: " + user.getName());

	        return user;
	    }
}
