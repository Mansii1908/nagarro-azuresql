package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.UserDao;
import com.nagarro.model.User1;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean validate(String emailId, String password) {
		String user=this.userDao.authenticate(emailId, password);
		if(user!=null) {
			return true;
		}
		return false;
	}

	@Override
	public User1 createUser(User1 user1) {
		return this.userDao.save(user1);
	}

	@Override
	public List<User1> getUser() {
		return this.userDao.findAll();
	}
	

}
