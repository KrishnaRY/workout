package com.workout.repository;

import java.util.List;

import com.workout.entity.WorkoutTransaction;

public interface IWorkoutTransactionRepository {
	long createWorkoutTransaction(WorkoutTransaction workoutTransaction);

	List getWorkoutTransactions(long workoutId);
}
