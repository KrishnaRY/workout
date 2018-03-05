package com.workout.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workout.entity.User;
import com.workout.entity.Workout;
@Repository
public class WorkoutRepository {
	@Autowired
	private SessionFactory sessionFactory;

	public long createWorkout(Workout workout) {
		System.out.println(workout.getUnitTime());
		return (Long)sessionFactory.openSession().save(workout);
		
		
	}

	public List getWorkouts(long userId) {
		Session session = sessionFactory.openSession();
	
		List<User> result = session.createQuery(" from Workout where userId=:userId")
		          .setParameter("userId",userId)
		          .list();
		return result;
	
	}
	
	
	public Workout getWorkout(long workoutId) {
		Session session = sessionFactory.openSession();
	
		List<Workout> result = session.createQuery(" from Workout where workoutId=:workoutId")
		          .setParameter("workoutId",workoutId)
		          .list();
		return result.get(0);
	
	}

	


}
