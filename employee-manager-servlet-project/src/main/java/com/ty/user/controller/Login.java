package com.ty.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.user.entity.User;
import com.ty.user.helper.UserFactory;

@WebServlet(value = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("user_email");
		String password = req.getParameter("user_password");
		
		User user = UserFactory.getUserDaoObject().validateUser(email, password);
		if(user != null) {
			HttpSession session = req.getSession();
			if(user.getUserRole().equals("manager")) {
				session.setAttribute("manager", user);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("manager.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				session.setAttribute("employee", user);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee.jsp");
				requestDispatcher.forward(req, resp);
			}
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<html><body><h2 style='color:red;'>Invalid Email or Password</h2></body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
			requestDispatcher.include(req, resp);
		}
		
	}
}
