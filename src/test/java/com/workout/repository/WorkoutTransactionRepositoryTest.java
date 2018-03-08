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
		WorkoutTransaction workoutTransaction=new WorkoutTransaction(1,  LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(1), Duration.ofHours(1),1000);
		long txnId=workoutTransactionService.createWorkoutTransaction(workoutTransaction);
	//		}
		assertNotEquals(txnId, 0);
		
	}
	
	@Test
	public void testgetWorkoutTransactions(){
	long starttime=System.currentTimeMillis();
	long workoutId=1;
		List workoutTransactionList=workoutTransactionService.getWorkoutTransactions(workoutId);
		System.out.println(System.currentTimeMillis()-starttime);
		long starttime1=System.currentTimeMillis();
		List workoutTransactionList1=workoutTransactionService.getWorkoutTransactions(workoutId);
		System.out.println(System.currentTimeMillis()-starttime1);
	}

	@Test
	@Timed(millis=200)
	public void testgetWorkoutTransactions1(){
		long workoutId=1;
		List workoutTransactionList=workoutTransactionService.getWorkoutTransactions(workoutId);
		System.out.println("workoutTransactionList===>"+workoutTransactionList.size());
	}
	
}
