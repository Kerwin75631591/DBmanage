package com.dbms.dao;

import java.sql.SQLException;

import com.dbms.entity.User;
import com.dbms.util.DBConnect;

public class UserCL {

	public DBConnect db;
	public UserCL() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Register(User ub) {
		int judge = 10;
		try {
			judge = db.searchUser(false, ub.getEmail(), ub.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (judge == 0) {
			try {
				db.insertUser(ub.getEmail(), ub.getPassword());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	public boolean Login(User ub) {
		int judge = 10;
		try {
			judge = db.searchUser(true, ub.getEmail(), ub.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (judge == 0)
			return true;
		else
			return false;

	}
}
