package com.dbms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.entity.Book;
import com.dbms.util.DBConnect;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class CheckOutServlet
 */
//@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CheckOutServlet() 
    {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//设置传输数据时的编码格式
		request.setCharacterEncoding("GBK");
		response.setContentType("GBK");
		response.setCharacterEncoding("GBK");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
		int orderID = Integer.valueOf(df.format(new Date()));
		
		DBConnect db = new DBConnect();
		db.connect();
		
		int uid = Integer.valueOf(request.getParameter("uid"));
		
		ArrayList<Book> books = new ArrayList<Book>();
		
		Book temp = new Book();
		
		String bookName = request.getParameter("bookName");
		temp.setBname(bookName);
		String bookAuthor = request.getParameter("bookAuthor");
		temp.setAuthor(bookAuthor);
		String isbn = request.getParameter("isbn");
		temp.setIsbn(isbn);
		int bookPrice = Integer.valueOf(request.getParameter("bookPrice"));
		temp.setPrice(bookPrice);
		int avalible = Integer.valueOf(request.getParameter("availible"));
		temp.setAvaliblity(avalible);
		int bookNumber = Integer.valueOf(request.getParameter("bookNumber"));
		temp.setBuynum(bookNumber);
		
		books.add(temp);
		
		String address = request.getParameter("address");
		String creditID = request.getParameter("creditID");
		
		db.insertOrder(orderID, uid, books, creditID, address);

		db.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
