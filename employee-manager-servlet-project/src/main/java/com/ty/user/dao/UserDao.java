package com.ty.user.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.ty.user.entity.Task;
import com.ty.user.entity.User;
import com.ty.user.helper.EntityFactoryDto;

public class UserDao {
	
	public User registerUser(User user) {
		
		if(isUserExist(user.getUserEmail())) {
			EntityFactoryDto.entityTransaction.begin();
			EntityFactoryDto.entityManager.persist(user);
			EntityFactoryDto.entityTransaction.commit();
		} else {
			return null;
		}
		
		return user;
	}
	
	public User validateUser(String email, String password) {
		
		User user = null;
		Query query = EntityFactoryDto.entityManager.createQuery("SELECT u FROM User u WHERE u.userEmail=?1 AND u.userPassword=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			user = (User) query.getSingleResult();
		} catch(NoResultException n) {
			user = null;
		}
		
		return user;
	}
	
	public boolean isUserExist(String email) {
		
		User user = null;
		Query query = EntityFactoryDto.entityManager.createQuery("SELECT u FROM User u WHERE u.userEmail=?1");
		query.setParameter(1, email);
		List<User> users = query.getResultList();
		
		return users.size() == 0;
	}
	
	public List<User> getEmployeeList() {
		
		Query query = EntityFactoryDto.entityManager.createQuery("SELECT u FROM User u WHERE u.userRole='employee'");
		return query.getResultList();
	}
	
	public List<Task> viewAllTasks(int employeeId) {
		
		Query query = EntityFactoryDto.entityManager.createQuery("SELECT t FROM User u JOIN u.tasks t WHERE u.userId =?1 ORDER BY t.status");
		query.setParameter(1, employeeId);
		
		return query.getResultList();
	}
	
}
