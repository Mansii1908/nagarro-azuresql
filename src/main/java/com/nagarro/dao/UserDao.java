package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.model.User1;

public interface UserDao extends JpaRepository<User1, String> {
	
	@Query(value = "SELECT emailId FROM User1 u WHERE u.emailId=?1 and u.password=?2")
	public String authenticate(String emailId,String password);
	
	

}
