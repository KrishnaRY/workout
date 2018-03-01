package com.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.entity.WorkoutTransaction;
import com.workout.service.WorkoutTransactionService;

@RestController
public class WorkoutTransactionController {

	@Autowired
	private WorkoutTransactionService workoutTransactionService;

	@RequestMapping(value = "/createWorkoutTransaction", method = RequestMethod.POST)
	public ResponseEntity<String> createWorkoutTransaction(@RequestBody WorkoutTransaction workoutTransaction) {
		workoutTransactionService.createWorkoutTransaction(workoutTransaction);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}
}
