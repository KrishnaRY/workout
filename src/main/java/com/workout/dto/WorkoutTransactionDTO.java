package com.workout.dto;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Column;

public class WorkoutTransactionDTO {

	private long txnId;

	private long workoutId;

	private String startTime;

	private String stopTime;
	private String duration;

	private double calsBurnt;

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(long workoutId) {
		this.workoutId = workoutId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getCalsBurnt() {
		return calsBurnt;
	}

	public void setCalsBurnt(double calsBurnt) {
		this.calsBurnt = calsBurnt;
	}

	public WorkoutTransactionDTO(long txnId, long workoutId, String startTime, String stopTime, String duration,
			double calsBurnt) {
		super();
		this.txnId = txnId;
		this.workoutId = workoutId;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.duration = duration;
		this.calsBurnt = calsBurnt;
	}
	
	public WorkoutTransactionDTO() {
		
	}
	
}
