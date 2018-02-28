package com.workout.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workout.entity.User;

@Repository
@Transactional
public class UserRepository {
	@Autowired
	private SessionFactory sessionFactory;
	public void createUser(User user) {
		System.out.println(user.getUserId());
	sessionFactory.openSession().save(user);
		
	}
	public List findUser(User user) {
		
		
		Session session = sessionFactory.openSession();
		List<User> result = session.createQuery(" from User where userName=:userName and password=:password")
		          .setParameter("userName", user.getUserName())
		          .setParameter("password", user.getPassword())
		          .list();
		
		return result;
	}
}