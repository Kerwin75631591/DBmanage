package com.dbms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.dao.UserCL;
import com.dbms.entity.User;
import com.dbms.util.*;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * Deal with the request from login.jsp
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		response.setContentType("GBK");
		response.setCharacterEncoding("GBK");

		// Get the userName and Password
		String uName = request.getParameter("LoginEmail");
		String pwd = request.getParameter("LoginPassword");

		User u = new User();
		u.setEmail(uName);
		u.setPassword(pwd);

		UserCL ucl = new UserCL();
		if (ucl.Login(u)) {
			ucl.db.close();
			request.getSession().setAttribute("sessionemail", u.getEmail());
			request.getSession().setAttribute("sessionpwd", u.getPassword());
			response.sendRedirect("./JSP/home.jsp"); // to a page (the current is home)
		} else {
			ucl.db.close();
			// deal with failure by alerting a window(wait to update)
			response.getWriter().print("<script type=\"text/javascript\">alert('faliure!');window.location='./JSP/login.jsp'</script>");
		}

	}

}
