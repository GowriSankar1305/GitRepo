package com.jocata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jocata.beans.User;

public class UserDao {
	
	Connection con = null;
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	
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
	
	public List<User> getAllUsers()	{
		String selectQuery = "select userId,name,phoneNo,email from user";
		List<User> list = null;
		try	{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root123");
			st = con.createStatement();
			rs = st.executeQuery(selectQuery);
			list = new ArrayList<User>();
			while(rs.next())	{
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setPhoneNo(rs.getString("phoneNo"));
				user.setEmail(rs.getString("email"));
				
				list.add(user);
			}
		}
		catch(SQLException se)	{
			se.printStackTrace();
		}
		finally {
			closeResources();
		}
		return list;
	}
}
