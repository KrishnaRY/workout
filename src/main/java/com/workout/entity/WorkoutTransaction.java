package com.workout.entity;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workout_transaction")
public class WorkoutTransaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="txn_id")
	private long txnId;
	@Column(name="workout_id")
	private long  workoutId ;
	@Column(name="start_time")
	private LocalDateTime   startTime ;
	@Column(name="stop_time")
	private LocalDateTime    stopTime;
	private Duration   duration  ;
	@Column(name="cals_burnt")
	private double  calsBurnt ;
	public long getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(long workoutId) {
		this.workoutId = workoutId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalDateTime getStopTime() {
		return stopTime;
	}
	public void setStopTime(LocalDateTime stopTime) {
		this.stopTime = stopTime;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public double getCalsBurnt() {
		return calsBurnt;
	}
	public void setCalsBurnt(double calsBurnt) {
		this.calsBurnt = calsBurnt;
	}
	public WorkoutTransaction(long workoutId, LocalDateTime startTime, LocalDateTime stopTime, Duration duration,
			double calsBurnt) {
		super();
		this.workoutId = workoutId;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.duration = duration;
		this.calsBurnt = calsBurnt;
	}
	public WorkoutTransaction() {
	
	}
	
	
	
	
}
