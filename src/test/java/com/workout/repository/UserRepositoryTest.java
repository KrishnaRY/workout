package com.workout.repository;

import org.aspectj.lang.annotation.Before;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

	private UserRepository userRepository;

	 @MockBean private SessionFactory sessionFactory;
	@Before(value = "")
	public void setup(){
		userRepository=new UserRepository();
	}
	@Test
	public void testJpaFind(){
	System.out.println(userRepository);
	}
}
