package com.workout.repository;

import static org.junit.Assert.assertNotEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.workout.SessionFactoryTest;
import com.workout.entity.WorkoutTransaction;
import com.workout.service.WorkoutTransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SessionFactoryTest.class })
public class WorkoutTransactionRepositoryTest {
	
	@Autowired
	private WorkoutTransactionService workoutTransactionService;
	@Autowired
	private WorkoutTransactionRepository workoutTransactionRepository;
	@Autowired
	private WorkoutRepository workoutRepository;
	@Test
	public void testCreateWorkOut(){
		//	for(int i=1;i<50;i++){
		WorkoutTransaction workoutTransaction=new WorkoutTransaction(8,  LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(1), Duration.ofHours(1),1000);
		long txnId=workoutTransactionService.createWorkoutTransaction(workoutTransaction);
	//		}
		assertNotEquals(txnId, 0);
		
	}
	
	@Test
	@Timed(millis=200)
	public void testgetWorkoutTransactions(){
		List workoutTransactionList=workoutTransactionService.getWorkoutTransactions();
		System.out.println("workoutTransactionList===>"+workoutTransactionList.size());
	}

}
