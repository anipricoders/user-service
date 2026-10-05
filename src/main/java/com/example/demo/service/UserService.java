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
			// TODO Auto-generated method stub
			return userRepository.findByGmailAndPassword(email, password);
		}
}
