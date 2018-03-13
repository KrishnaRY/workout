package com.workout.service;

import java.util.List;

import com.workout.entity.Workout;

public interface IWorkoutService {
	List getWorkouts(long userId);

	long createWorkout(Workout workout);

	Workout getWorkout(long workoutId);
}
