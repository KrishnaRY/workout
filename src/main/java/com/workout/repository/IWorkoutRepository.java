package com.workout.repository;

import java.util.List;

import com.workout.entity.Workout;

public interface IWorkoutRepository {
	long createWorkout(Workout workout);

	List getWorkouts(long userId);

	Workout getWorkout(long workoutId);

}
