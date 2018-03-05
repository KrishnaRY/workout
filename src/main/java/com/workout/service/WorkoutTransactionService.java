package com.workout.service;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.workout.entity.Workout;
import com.workout.entity.WorkoutTransaction;
import com.workout.repository.WorkoutRepository;
import com.workout.repository.WorkoutTransactionRepository;

@Service
@Transactional
public class WorkoutTransactionService {
	@Autowired
	private WorkoutTransactionRepository workoutTransactionRepository;
	@Autowired
	private WorkoutRepository workoutRepository;

	public long createWorkoutTransaction(WorkoutTransaction workoutTransaction) {
		Workout workout = workoutRepository.getWorkout(workoutTransaction.getWorkoutId());
		long duration = Duration.between(workoutTransaction.getStartTime(), workoutTransaction.getStopTime())
				.toMillis();
		workoutTransaction
				.setDuration(Duration.between(workoutTransaction.getStartTime(), workoutTransaction.getStopTime()));
		workoutTransaction.setCalsBurnt(calculateCalsBurnt(duration, workout));

		return workoutTransactionRepository.createWorkoutTransaction(workoutTransaction);
	}

	private double calculateCalsBurnt(long duration, Workout workout) {

		double calsBurnt = 0;
		if (workout.getUnitTime().name().equals("HOUR")) {
			calsBurnt = (workout.getCalBurntPerUnitTime() / TimeUnit.HOURS.toMillis(1));
		} else if (workout.getUnitTime().name().equals("MINUTE")) {
			calsBurnt = (workout.getCalBurntPerUnitTime() / TimeUnit.MINUTES.toMillis(1));
		} else if (workout.getUnitTime().name().equals("SECOND")) {
			calsBurnt = (workout.getCalBurntPerUnitTime() / TimeUnit.SECONDS.toMillis(1));
		} else {
			calsBurnt = 0;
		}

		return calsBurnt * duration;
	}

	@Cacheable(value = "WorkoutTransaction")
	public List getWorkoutTransactions() {
		
		 return workoutTransactionRepository.getWorkoutTransactions();
	}

}
