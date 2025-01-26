package com.springboard.internship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboard.internship.dao.UserRepository;
import com.springboard.internship.entities.User;

@Service
public class UserService {
	@Autowired 
	private UserRepository userRepository;

	 public void updateUserProfile(User updatedUser) {
	        // Fetch the user from the database by ID
	        User existingUser = userRepository.findById(updatedUser.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

	        // Update the user's details
	        existingUser.setName(updatedUser.getName());
	        existingUser.setContact(updatedUser.getContact());
	        existingUser.setAddress(updatedUser.getAddress());

	        // Save the updated user
	        userRepository.save(existingUser);
	    }
}
















