package com.jocata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jocata.beans.Book;

public class BookDao {
		
	Connection con = null;
	ResultSet rs = null;
	Statement st = null;
	PreparedStatement ps = null;
	
	public void saveBook(Book book)	{
		try	{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root123");
			ps = con.prepareStatement("insert into book values (?,?,?,?)");
			ps.setLong(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setDouble(3, book.getPrice());
			ps.setString(4, book.getAuthorName());
			ps.executeUpdate();
		}
		catch(SQLException se)	{
			se.printStackTrace();
		}
		finally	{
			closeResources();
		}
	}
	
	public void closeResources()	{
		try {
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
		try {
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
		try {
				if (ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
		try {
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
