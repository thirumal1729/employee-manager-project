package com.ty.user.helper;

import com.ty.user.dao.TaskDao;
import com.ty.user.entity.Task;

public class TaskFactory {
	
	public static Task getTaskObject(String description, String status) {
		Task task = new Task();
		task.setDescription(description);
		task.setStatus("assigned");
		
		return task;
	}
	
	public static TaskDao getTaskDaoObject() {
		return new TaskDao();
	}
	
}
