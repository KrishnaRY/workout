package com.workout.repository;

import java.sql.Timestamp;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.workout.entity.WorkoutTransaction;
@Repository
public class WorkoutTransactionRepository {
	@Autowired
	private SessionFactory sessionFactory;
	public void createWorkoutTransaction(WorkoutTransaction workoutTransaction) {
		Session session = sessionFactory.openSession();
		
		Query query = session.createSQLQuery("INSERT INTO workout_transaction(workout_id, start_time, stop_time,duration,cals_burnt) VALUES (:workoutId, :startTime, :stopTime,:duration,:calsBurnt)");
		query.setParameter("workoutId", workoutTransaction.getWorkoutId());
		query.setParameter("startTime", Timestamp.valueOf(workoutTransaction.getStartTime()));
		query.setParameter("stopTime", Timestamp.valueOf(workoutTransaction.getStopTime()));
		query.setParameter("duration", workoutTransaction.getDuration().toMillis());
		query.setParameter("calsBurnt", workoutTransaction.getCalsBurnt());
		query.executeUpdate();
		//sessionFactory.openSession().save(workoutTransaction);
		
	}
}
