package com.workout.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.entity.User;
import com.workout.repository.IUserRepository;

@Service
@Transactional
public class UserServiceImpl  implements IUserService{
	@Autowired
	private IUserRepository userRepository;

	public long createUser(User user) {
	return	userRepository.createUser(user);
		
	}

	public List findUser(User user) {
		return userRepository.findUser(user);
	}
	
}
