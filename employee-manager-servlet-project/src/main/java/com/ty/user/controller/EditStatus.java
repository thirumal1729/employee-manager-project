package com.ty.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.user.dao.TaskDao;
import com.ty.user.entity.Task;
import com.ty.user.helper.TaskFactory;

@WebServlet(value = "/editStatus")
public class EditStatus extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int taskId = Integer.parseInt(req.getParameter("taskId"));
		String status = req.getParameter("status");
		
		TaskDao taskDao = TaskFactory.getTaskDaoObject();
		Task task = taskDao.editTaskStatus(taskId, status);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("EmployeeViewTask.jsp");
		requestDispatcher.forward(req, resp);
	}
}
