package com.workout.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity

public class Workout  implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long workoutId;
	public long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(long workoutId) {
		this.workoutId = workoutId;
	}
	private String title ;
	private double  calBurntPerUnitTime ;
	private  String unitTime ;
	private  long userId  ;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="workoutId")
	private List<WorkoutTransaction> workoutTransaction=new ArrayList<WorkoutTransaction>();
	public Workout(String title, double calBurntPerUnitTime, UnitTime unitTime, long userId) {
		super();
		this.title = title;
		this.calBurntPerUnitTime = calBurntPerUnitTime;
		this.unitTime = unitTime.name();
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
	public String getUnitTime() {
		return unitTime;
	}
	public void setUnitTime(String unitTime) {
		this.unitTime = unitTime;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	
}
