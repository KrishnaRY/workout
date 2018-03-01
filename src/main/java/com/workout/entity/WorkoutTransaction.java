package com.workout.entity;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkoutTransaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long txnId;
	private long  workoutId ;
	private LocalDateTime   startTime ;
	private LocalDateTime    stopTime;
	private Duration   duration  ;
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
