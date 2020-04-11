package com.jocata.dao;

import com.jocata.beans.User;

public class UserDao {
	
	public void saveUser(User user)	{
		System.out.println("saving user...");
		System.out.println(user);
	}
}
