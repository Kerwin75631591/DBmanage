package com.dbms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.dbms.entity.Book;

public class DBConnect {
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet rs = null;

	public DBConnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("无法找到驱动类");
		}
	}

	// 连接数据库
	public void connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/"
					+ "DBMSdb?user=root&password=749847569&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
			connection = DriverManager.getConnection(dbURL);
			statement = connection.createStatement();
			System.out.println("数据库已连接");
		} catch (ClassNotFoundException e) {
			System.out.println("无法找到驱动类");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库无法连接");
		}
	}

	// 在User中加入新的数据
	public void insertUser(String email, String password)
			throws SQLException {
		String sql = "SELECT id FROM User ";
		rs = statement.executeQuery(sql);
		int id = 0;
		while (rs.next()) {
			id = rs.getInt("id");
		}
		id = id + 1;
		sql = "INSERT INTO User(id ,email ,password)values(?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		pstmt.addBatch();
		pstmt.clearParameters();
		pstmt.executeBatch();
		pstmt.clearBatch();
	}

	// 在User中删除数据
	public void deleteUser(String email) throws SQLException {
		String sql = "DELETE * FROM User WHERE email = " + email;
		statement.execute(sql);
	}

	// User修改密码
	public void updateUserpassword(String email, String newPassword) throws SQLException {
		String sql = "UPDATE User SET password = " + newPassword + " WHERE   email = '" + email + "'";
		System.out.println(sql);
		statement.executeUpdate(sql);
	}

	// User登录(true)&注册(false)检测 返回值0为通过，登录中1为密码错误，2为账号不存在，注册中1为该邮箱已注册
	public int searchUser(boolean judge, String email, String password) throws SQLException {
		String sql = "SELECT*FROM User";
		rs = statement.executeQuery(sql);
		System.out.println("rs表已创建");
		if (judge) {
			while (rs.next()) {
				if (email.equals(rs.getString("email"))) {
					if (password.equals(rs.getString("password")))
						return 0;
					else
						return 1;
				}
			}
			return 2;
		} else {
			while (rs.next()) {
				if (email.equals(rs.getString("email")))
					return 1;
			}
			return 0;
		}
	}

	// 在book中加入新的数据
	public int insertbook(String isbn, String bname, String author,int price,int storage,int avaliblity) throws SQLException {
		String sql = "INSERT INTO book(isbn,bname,author,price,storage,avaliblity)values(?,?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,isbn);
		pstmt.setString(2,bname);
		pstmt.setString(3,author);
		pstmt.setInt(4, price);
		pstmt.setInt(5, storage);
		pstmt.setInt(6, avaliblity);
		pstmt.addBatch();
		pstmt.clearParameters();
		pstmt.executeBatch();
		pstmt.clearBatch();

		return avaliblity;
	}

	// book搜索，返回resultset
	public ResultSet searchbook(String searchid,int mode) throws SQLException {
		String sql=null;
		if(mode==1)
			sql = "SELECT * FROM book WHERE isbn = '" + searchid + "'";
		else if(mode==2)
			sql = "SELECT * FROM book WHERE bname = '" + searchid + "'";
		else if(mode==3)
			sql = "SELECT * FROM book WHERE author = '" + searchid + "'";
		rs = statement.executeQuery(sql);
		return rs;
	}


	// book修改数量
	public void updateBookNum(int isbn, int num) throws SQLException {
		String sql="SELECT storage FROM book WHERE isbn = '" + isbn + "'";
		rs = statement.executeQuery(sql);
		while(rs.next()){
			num+=rs.getInt("storage");
		}
		sql = "UPDATE book SET storage = " + num + " WHERE   isbn = '" + isbn + "'";
		System.out.println(sql);
		statement.executeUpdate(sql);

	}

	// 在order中加入新的数据
	public void insertOrder(int oid,int uid, ArrayList<Book> books,String credit,String address) throws SQLException {
		System.out.println("insertOrder已进入");
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			Book p = it.next();
			System.out.println(p.getIsbn() + "+" + p.getBuynum());

			String sql = "INSERT INTO order(oid,uid,num,isbn,credit,address)values(?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, oid);
			pstmt.setInt(2, uid);
			pstmt.setInt(3, p.getBuynum());
			pstmt.setString(4, p.getIsbn());
			pstmt.setString(5, credit);
			pstmt.setString(6, address);
			pstmt.addBatch();
			pstmt.clearParameters();
			pstmt.executeBatch();
			pstmt.clearBatch();

		}
	}

	// order搜索所有该uid的会议，返回resultset
	public ResultSet searchPeople(int uid) throws SQLException {
		String sql = "SELECT * FROM order WHERE uid = '" + uid + "'";
		rs = statement.executeQuery(sql);
		return rs;
	}

	// 关闭数据库连接
	public void close() {
		try {
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
