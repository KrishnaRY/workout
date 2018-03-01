package com.workout.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity

public class Workout  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="workout_id")
	private long workoutId;
	

	public long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(long workoutId) {
		this.workoutId = workoutId;
	}
	private String title ;
	@Column(name="cal_burnt_per_unit_time")
	private double  calBurntPerUnitTime ;
	@Enumerated(EnumType.STRING)
	@Column(name="unit_time")
	private  UnitTime unitTime ;
	@Column(name="user_id")
	private  long userId  ;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="workoutId")
	private List<WorkoutTransaction> workoutTransaction=new ArrayList<WorkoutTransaction>();
	public Workout(String title, double calBurntPerUnitTime, UnitTime unitTime, long userId) {
		super();
		this.title = title;
		this.calBurntPerUnitTime = calBurntPerUnitTime;
		this.unitTime = unitTime;
		this.userId = userId;
	}
	
	public Workout() {
	
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getCalBurntPerUnitTime() {
		return calBurntPerUnitTime;
	}
	public void setCalBurntPerUnitTime(double calBurntPerUnitTime) {
		this.calBurntPerUnitTime = calBurntPerUnitTime;
	}
	public UnitTime getUnitTime() {
		return unitTime;
	}
	public void setUnitTime(UnitTime unitTime) {
		this.unitTime = unitTime;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	
}
