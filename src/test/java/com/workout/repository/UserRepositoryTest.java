package com.workout.repository;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workout.SessionFactoryTest;
import com.workout.entity.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SessionFactoryTest.class })
public class UserRepositoryTest {
	@Autowired
	 IUserRepository userRepository;

	//private SessionFactory sessionFactory;
	
	@Test
	public void testJpaFind(){
		User user= new User("admin123","admin123");
		
		long userid=userRepository.createUser(user);
		assertNotEquals(userid, 0);
	}
}
