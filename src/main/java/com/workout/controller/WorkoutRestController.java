package com.workout.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.entity.Workout;
import com.workout.entity.WorkoutTransaction;
import com.workout.repository.WorkoutRepository;
import com.workout.util.Util;

@RestController
public class WorkoutRestController {
	@Autowired
	private WorkoutRepository  workoutRepository;
	
	@RequestMapping(value = "/createWorkout", method = RequestMethod.POST)
	  public ResponseEntity<String> createWorkout(@RequestBody Workout workout) {
	
		workoutRepository.createWorkout(workout);
	      return ResponseEntity.status(HttpStatus.CREATED).build();
	   
	   
	  }
	@RequestMapping(value = "/getWorkouts/{userId}", method = RequestMethod.GET)
	 public List getWorkouts(@PathVariable long userId) {
			
		List workoutList=	workoutRepository.getWorkouts(userId);
		System.out.println(workoutList);
		    
		   return workoutList;
		   
		  }
	
	
	@RequestMapping(value = "/createWorkoutTransaction", method = RequestMethod.POST)
	 public ResponseEntity<String>  createWorkoutTransaction(@RequestBody WorkoutTransaction workoutTransaction) {
		
		
		Workout workout=workoutRepository.getWorkout(workoutTransaction.getWorkoutId());
			
		
		long   duration  = Duration.between( workoutTransaction.getStartTime(),workoutTransaction.getStopTime() ).toMillis();
		Util.calculateCalsBurnt(duration,workout);
		System.out.println(Duration.between( workoutTransaction.getStartTime(),workoutTransaction.getStopTime()));
		workoutTransaction.setDuration(Duration.between( workoutTransaction.getStartTime(),workoutTransaction.getStopTime()));
		workoutTransaction.setCalsBurnt(Util.calculateCalsBurnt(duration,workout));
		
		workoutRepository.createWorkoutTransaction(workoutTransaction)  ; 
		return ResponseEntity.status(HttpStatus.CREATED).build();
		   
		  }
	
	
	

}
