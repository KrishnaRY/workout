package com.workout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.entity.User;
import com.workout.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		userRepository.createUser(user);
		
	}

	public List findUser(User user) {
		return userRepository.findUser(user);
	}
	
}
