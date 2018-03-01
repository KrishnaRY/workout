package com.workout.controller;

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
import com.workout.service.WorkoutService;

@RestController
public class WorkoutRestController {
	@Autowired
	private WorkoutService workoutService;

	@RequestMapping(value = "/createWorkout", method = RequestMethod.POST)
	public ResponseEntity<String> createWorkout(@RequestBody Workout workout) {

		workoutService.createWorkout(workout);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@RequestMapping(value = "/getWorkouts/{userId}", method = RequestMethod.GET)
	public List getWorkouts(@PathVariable long userId) {

		return workoutService.getWorkouts(userId);

	}

}
