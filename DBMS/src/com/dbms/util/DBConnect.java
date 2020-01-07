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
			System.out.println("�޷��ҵ�������");
		}
	}

	// �������ݿ�
	public void connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/"
					+ "DBMSdb?user=root&password=749847569&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
			connection = DriverManager.getConnection(dbURL);
			statement = connection.createStatement();
			System.out.println("���ݿ�������");
		} catch (ClassNotFoundException e) {
			System.out.println("�޷��ҵ�������");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ��޷�����");
		}
	}

	// ��User�м����µ�����
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

	// ��User��ɾ������
	public void deleteUser(String email) throws SQLException {
		String sql = "DELETE * FROM User WHERE email = " + email;
		statement.execute(sql);
	}

	// User�޸�����
	public void updateUserpassword(String email, String newPassword) throws SQLException {
		String sql = "UPDATE User SET password = " + newPassword + " WHERE   email = '" + email + "'";
		System.out.println(sql);
		statement.executeUpdate(sql);
	}

	// User��¼(true)&ע��(false)��� ����ֵ0Ϊͨ������¼��1Ϊ�������2Ϊ�˺Ų����ڣ�ע����1Ϊ��������ע��
	public int searchUser(boolean judge, String email, String password) throws SQLException {
		String sql = "SELECT*FROM User";
		rs = statement.executeQuery(sql);
		System.out.println("rs���Ѵ���");
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

	// ��book�м����µ�����
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

	// book����������resultset
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


	// book�޸�����
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

	// ��order�м����µ�����
	public void insertOrder(int oid,int uid, ArrayList<Book> books,String credit,String address) throws SQLException {
		System.out.println("insertOrder�ѽ���");
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

	// order�������и�uid�Ļ��飬����resultset
	public ResultSet searchPeople(int uid) throws SQLException {
		String sql = "SELECT * FROM order WHERE uid = '" + uid + "'";
		rs = statement.executeQuery(sql);
		return rs;
	}

	// �ر����ݿ�����
	public void close() {
		try {
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
