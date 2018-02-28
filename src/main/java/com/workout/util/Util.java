package com.workout.util;

import java.util.concurrent.TimeUnit;

import com.workout.entity.Workout;

public class Util {
	
	public static double calculateCalsBurnt (long duration, Workout workout){
		
		double calsBurnt=0;
		if(workout.getUnitTime().equals("HOURS")){
			calsBurnt= (workout.getCalBurntPerUnitTime()/TimeUnit.HOURS.toMillis(1));
		}else if(workout.getUnitTime().equals("MINUTE")){
			calsBurnt= (workout.getCalBurntPerUnitTime()/TimeUnit.MINUTES.toMillis(1));
		}else if(workout.getUnitTime().equals("SECOND")){
			calsBurnt= (workout.getCalBurntPerUnitTime()/TimeUnit.SECONDS.toMillis(1));
		}else{
			calsBurnt=0;	
		}
		
		
		
		return calsBurnt * duration;
	}

}
