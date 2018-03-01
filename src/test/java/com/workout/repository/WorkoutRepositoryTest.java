package com.workout.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workout.SessionFactoryTest;
import com.workout.entity.UnitTime;
import com.workout.entity.Workout;
import com.workout.repository.WorkoutRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SessionFactoryTest.class })
public class WorkoutRepositoryTest {
@Autowired
private WorkoutRepository workoutRepository;

@Test
public void testCreateWorkOut(){
	Workout workout=new Workout("Walking", 200, UnitTime.HOUR, 1);
	
	workoutRepository.createWorkout(workout);
	
}

@Test
public void testgetWorkouts(){
	
	long userid=1;
	List<Workout> workoutList=workoutRepository.getWorkouts(userid);
	System.out.println("workoutList==>"+workoutList);
}






}
