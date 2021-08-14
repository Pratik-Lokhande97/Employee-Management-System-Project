package com.dao;

import com.model.User;

public class RegistrationDao {
	
	public void save(User u)
	{
		System.out.println("------------"+u.getName());
	}

}
