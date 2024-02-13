package com.ty.user.dao;

import java.util.List;

import javax.persistence.Query;

import com.ty.user.entity.Task;
import com.ty.user.entity.User;
import com.ty.user.helper.EntityFactoryDto;

public class TaskDao {

	public Task addTask(int employeeId, Task task) {
		
		User employee = EntityFactoryDto.entityManager.find(User.class, employeeId);
		List<Task> tasks = employee.getTasks();
		tasks.add(task);
		
		EntityFactoryDto.entityTransaction.begin();
		EntityFactoryDto.entityManager.persist(task);
		EntityFactoryDto.entityManager.merge(employee);
		EntityFactoryDto.entityTransaction.commit();
		
		return task;
	}
	
	public List<Task> viewAllTasks() {
		
		Query query = EntityFactoryDto.entityManager.createQuery("SELECT t FROM Task t");
		return query.getResultList();
	}
	
	public Task editTaskStatus(int taskId, String status) {
		
		Task task = EntityFactoryDto.entityManager.find(Task.class, taskId);
		task.setStatus(status);
		EntityFactoryDto.entityTransaction.begin();
		EntityFactoryDto.entityManager.merge(task);
		EntityFactoryDto.entityTransaction.commit();
		
		return task;
	}
}
