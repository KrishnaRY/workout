package com.workout.service;

import java.util.List;

import com.workout.entity.WorkoutTransaction;

public interface IWorkoutTransactionService {
	long createWorkoutTransaction(WorkoutTransaction workoutTransaction);

	List getWorkoutTransactions(long workoutId);

}
