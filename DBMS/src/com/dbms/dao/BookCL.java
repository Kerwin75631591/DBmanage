package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbms.entity.Book;
import com.dbms.util.DBConnect;

public class BookCL {

	public DBConnect db;
	public ResultSet rs = null;

	
	public BookCL() {
		db = new DBConnect();
		try {
			db.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  ResultSet Search(Book b) {
		try {
			if(!b.getIsbn().isEmpty()) {
				rs = db.searchbook(b.getIsbn(), 1);
			} else if(!b.getBname().isEmpty()) {
				rs = db.searchbook(b.getBname(), 2);
			} else if(!b.getAuthor().isEmpty()) {
				rs = db.searchbook(b.getAuthor(), 3);
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int UpdateBook(Book b,int num) {
		rs=Search(b);
		try {
			if(rs.next()) {
				db.updateBookNum(b.getIsbn(), num);
			}else {
				return 1;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
		}
		return 0;
	}
	
	public int InsertBook(Book b,int num) {
		if(b.getIsbn().length()==10||b.getIsbn().length()==13) {
			try {
				db.insertbook(b.getIsbn(), b.getBname(), b.getAuthor(), b.getPrice(), b.getStorage(), b.getAvaliblity());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 1;
			}
			
		}else {
			return 2;
		}
		return 0;
	}
}
