package com.ty.user.helper;

import java.util.ArrayList;
import java.util.List;

import com.ty.user.dao.UserDao;
import com.ty.user.entity.Task;
import com.ty.user.entity.User;

public class UserFactory {

	public static User getUserObject(String name, String email, String password, String role, String designation, double salary) {
		
		User user = new User();
		user.setUserName(name);
		user.setUserEmail(email);
		user.setUserPassword(password);
		user.setUserRole(role);
		user.setUserDesignation(designation);
		user.setUserSalary(salary);
		
		List<Task> tasks = new ArrayList<Task>();
		user.setTasks(tasks);
		
		return user;
	}
	
	public static UserDao getUserDaoObject() {
		return new UserDao();
	}
}
