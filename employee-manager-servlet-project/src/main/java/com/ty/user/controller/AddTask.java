package com.ty.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.user.dao.TaskDao;
import com.ty.user.entity.Task;
import com.ty.user.helper.TaskFactory;

@WebServlet(value = "/addTask")
public class AddTask extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		String description = req.getParameter("description");
		String status = req.getParameter("status");
		Task task = TaskFactory.getTaskObject(description, status);
		TaskDao taskDao = TaskFactory.getTaskDaoObject();
		task = taskDao.addTask(employeeId, task);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("task.jsp");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><center><h2>Task added successfully...!</h2></center></body></html>");
		requestDispatcher.include(req, resp);
		
	}
}
