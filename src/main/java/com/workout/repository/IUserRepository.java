package com.workout.repository;

import java.util.List;

import com.workout.entity.User;

public interface IUserRepository {
	long createUser(User user);

	List findUser(User user);
}
