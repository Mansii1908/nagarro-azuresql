package com.nagarro.service;

import java.util.List;

import com.nagarro.model.User1;

public interface UserService {
	public boolean validate(String emailId,String password);
	
	public User1 createUser(User1 user1);
	
	public List<User1> getUser();
}
