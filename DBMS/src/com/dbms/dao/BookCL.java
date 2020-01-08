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
	
	public  void Search(Book b) {
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
		db.close();
	}
}
