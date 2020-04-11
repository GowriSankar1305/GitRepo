package com.jocata.service;

import java.util.List;

import com.jocata.beans.User;
import com.jocata.dao.UserDao;

public class UserService {
	
	UserDao dao = new UserDao();
	
	public void saveUser(User user)	{
		dao.saveUser(user);
	}
	
	public void displayAllEmployees()	{
		List<User> users = dao.getAllUsers();
		if (users != null && users.size() > 0)	{
			users.forEach(item -> {
				System.out.println(item.getName()+" "+item.getPhoneNo()+" "+item.getEmail());
			});
		}
		else	{
			System.out.println("No users found...");
		}
	}
}
