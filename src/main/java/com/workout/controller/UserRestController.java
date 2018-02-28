package com.workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.entity.User;
import com.workout.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	  public ResponseEntity<String> persistPerson(@RequestBody User user) {
	
	    	userRepository.createUser(user);
	      return ResponseEntity.status(HttpStatus.CREATED).build();
	   
	   
	  }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	  public ResponseEntity login(@RequestBody User user) {
	
		List userList =	userRepository.findUser(user);
		if(userList.size() > 0){
			return new ResponseEntity<>( userList.get(0), HttpStatus.OK);
		}else{
			 return new ResponseEntity<>(" Invalid User Name / Password ...", HttpStatus.FORBIDDEN);
		}
	   
	   
	  }

}
