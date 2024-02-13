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

@WebServlet(value = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h2>Logged out successfully...!</h2></body></html>");
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
		requestDispatcher.include(req, resp);
		
	}
	
}
