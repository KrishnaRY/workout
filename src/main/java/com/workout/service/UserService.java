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

	public long createUser(User user) {
	return	userRepository.createUser(user);
		
	}

	public List findUser(User user) {
		return userRepository.findUser(user);
	}
	
}
