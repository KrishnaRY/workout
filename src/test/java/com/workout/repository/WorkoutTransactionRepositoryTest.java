package com.workout.repository;

import static org.junit.Assert.assertNotEquals;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workout.SessionFactoryTest;
import com.workout.entity.WorkoutTransaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SessionFactoryTest.class })
public class WorkoutTransactionRepositoryTest {
	
	@Autowired
	private WorkoutTransactionRepository workoutTransactionRepository;
	
	@Test
	public void testCreateWorkOut(){

		WorkoutTransaction workoutTransaction=new WorkoutTransaction(8,  LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(1), Duration.ofHours(1),7777);
			
		
		long txnId=workoutTransactionRepository.createWorkoutTransaction(workoutTransaction);
		assertNotEquals(txnId, 0);
		
	}

}
