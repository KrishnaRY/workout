package com.workout.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.workout.dto.WorkoutTransactionDTO;
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
	public List getWorkoutTransactions(long workoutId) {
		List workTrans=workoutTransactionRepository.getWorkoutTransactions(workoutId);
	//getWorkoutTransDto(workTrans);
		 return getWorkoutTransDto(workTrans);
	}

	private List getWorkoutTransDto(List workTrans) {
		List workoutDtoList=new ArrayList();
			for (int i = 0; i < workTrans.size(); i++) {
				Object[] result=(Object[]) workTrans.get(i);
			
				WorkoutTransactionDTO workoutTransactionDTO=new WorkoutTransactionDTO((Long)result[0],(Long)result[1],(String)result[2],(String)result[3],DurationFormatUtils.formatDuration((Long)result[4], "HH:mm:ss,SSS"),(Double)result[5]);
				
				workoutDtoList.add(workoutTransactionDTO)	;	  
				
				
			}
			return workoutDtoList;
	}
	

}
