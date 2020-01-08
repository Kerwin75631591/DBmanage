package com.dbms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.dao.UserCL;
import com.dbms.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("GBK");
		response.setContentType("GBK");
		response.setCharacterEncoding("GBK");
		
		String email=request.getParameter("Email");
		String pw=request.getParameter("Password");

		
		User u=new User();
		Boolean success=false;

		
		if(email!=null&&pw!=null)
		{
			u.setEmail(email);
			u.setPassword(pw);
			UserCL ubc=new UserCL();
			
			System.out.println(u.getEmail()+"\n"+u.getPassword());
			
			success=ubc.Register(u);
			if(success){
				ubc.db.close();
				request.getSession().setAttribute("sessionemail",u.getEmail()); 
	    		request.getSession().setAttribute("sessionpwd",u.getPassword());
				response.sendRedirect("./JSP/"+"home.jsp");
			}else{
				ubc.db.close();
				//response.sendRedirect("Register.jsp");
			}
		}
	}

}
