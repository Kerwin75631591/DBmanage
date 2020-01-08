package com.dbms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.dao.BookCL;
import com.dbms.entity.Book;

/**
 * Servlet implementation class SearchServlet
 */
//@WebServlet(name="searchServlet", urlPatterns="/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Search the book from database
		doGet(request, response);
		
		request.setCharacterEncoding("GBK");
		response.setContentType("GBK");
		response.setCharacterEncoding("GBK");
		
		String isbn = request.getParameter("ISBN");
		String author = request.getParameter("Author");
		String bname = request.getParameter("BookName");
		
		Book b = new Book();
		b.setIsbn(isbn);
		b.setAuthor(author);
		b.setBname(bname);
		
		BookCL bc = new BookCL();
		bc.Search(b);
		
		// Send the book's information to bookinfo.jsp
		
	}

}
