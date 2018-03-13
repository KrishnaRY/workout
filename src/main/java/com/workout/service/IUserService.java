package com.workout.service;

import java.util.List;

import com.workout.entity.User;

public interface IUserService {
	long createUser(User user);

	public List findUser(User user);
}
