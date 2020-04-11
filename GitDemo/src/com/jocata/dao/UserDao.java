package com.jocata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.jocata.beans.User;

public class UserDao {
	
	Connection con = null;
	PreparedStatement ps = null;
	Statement st = null;
	
	public void saveUser(User user)	{
		String insertQuery = "insert into user values (?,?,?,?)";
		try	{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root123");
			ps = con.prepareStatement(insertQuery);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPhoneNo());
			ps.setString(4, user.getEmail());
			ps.executeUpdate();
		}
		catch(SQLException se)	{
			se.printStackTrace();
		}
		finally {
			try {
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
