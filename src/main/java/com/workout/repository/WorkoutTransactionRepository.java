package com.workout.repository;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workout.entity.Workout;
import com.workout.entity.WorkoutTransaction;
@Repository
public class WorkoutTransactionRepository {
	@Autowired
	private SessionFactory sessionFactory;
	public long createWorkoutTransaction(WorkoutTransaction workoutTransaction) {
		Session session = sessionFactory.openSession();
		
		Query query = session.createSQLQuery("INSERT INTO workout_transaction(workout_id, start_time, stop_time,duration,cals_burnt) VALUES (:workoutId, :startTime, :stopTime,:duration,:calsBurnt)");
		query.setParameter("workoutId", workoutTransaction.getWorkoutId());
		query.setParameter("startTime", Timestamp.valueOf(workoutTransaction.getStartTime()));
		query.setParameter("stopTime", Timestamp.valueOf(workoutTransaction.getStopTime()));
		query.setParameter("duration", workoutTransaction.getDuration().toMillis());
		query.setParameter("calsBurnt", workoutTransaction.getCalsBurnt());
	return	query.executeUpdate();
		//sessionFactory.openSession().save(workoutTransaction);
		
	}
	public List getWorkoutTransactions(long workoutId) {
		Session session = sessionFactory.openSession();
		
		
		List<WorkoutTransaction> result = ((SQLQuery) session.createSQLQuery("select txn_id,workout_id,start_time, stop_time,duration,cals_burnt  from workout_transaction  where workout_id=:workout_id")
				  .setParameter("workout_id",workoutId))
				  .addScalar("txn_id", StandardBasicTypes.LONG)
				  .addScalar("workout_id", StandardBasicTypes.LONG)
				  .addScalar("start_time", StandardBasicTypes.STRING)
				  .addScalar("stop_time", StandardBasicTypes.STRING)
				  .addScalar("duration", StandardBasicTypes.LONG)
				  .addScalar("cals_burnt", StandardBasicTypes.DOUBLE)
				  
				  .list();
		
		return result;
	}
}
