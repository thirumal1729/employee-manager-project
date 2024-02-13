package com.ty.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.user.dao.UserDao;
import com.ty.user.entity.User;
import com.ty.user.helper.UserFactory;

@WebServlet(value = "/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		String password = req.getParameter("user_password");
		String role = req.getParameter("role");
		String designation = req.getParameter("user_designation");
		double salary = Double.parseDouble(req.getParameter("user_salary"));
		
		User user = UserFactory.getUserObject(name, email, password, role, designation, salary);
		UserDao userDao = UserFactory.getUserDaoObject();
		user = userDao.registerUser(user);
		
		PrintWriter printWriter = resp.getWriter();
		
		if(user != null) {
			printWriter.print("<html><body><h2>Registered Successfully...!</h2></body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
			requestDispatcher.include(req, resp);
		} else {
			printWriter.print("<html><body><h2>Email is not available...!</h2></body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.html");
			requestDispatcher.include(req, resp);
		}
	}
}
