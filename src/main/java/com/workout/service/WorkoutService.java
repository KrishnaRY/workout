package com.workout.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.entity.Workout;
import com.workout.repository.WorkoutRepository;

@Service
@Transactional
public class WorkoutService {
	@Autowired
	WorkoutRepository  workoutRepository;
	public List getWorkouts(long userId) {
		
		return workoutRepository.getWorkouts(userId);
	}

	public long createWorkout(Workout workout) {
		return workoutRepository.createWorkout(workout);
		
	}

}
