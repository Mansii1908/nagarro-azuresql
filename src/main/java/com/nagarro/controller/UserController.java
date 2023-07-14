package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.User1;
import com.nagarro.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//get all users
	@GetMapping("/user")
	public List<User1> getUsers() {
		return this.userService.getUser();
	}
	
	//check user login details
	//user login details 
	@PostMapping("/userLogin")
	public ResponseEntity<Boolean> checkLogin(@RequestBody User1 user1) {
		try {
//			Boolean result=false;
			System.out.println(user1.getEmailId()); 
			System.out.println(user1.getPassword()); 

			List<User1> userList=this.userService.getUser();
			for(User1 currUser:userList) {
				if(currUser.getEmailId().equals(user1.getEmailId()) && currUser.getPassword().equals(user1.getPassword())){
					return ResponseEntity.status(HttpStatus.OK).body(true);
				}
			}
//			Boolean result=this.userService.validate(user.getEmailId(), user.getPassword());
			return ResponseEntity.status(HttpStatus.OK).body(false);
			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	
	//create user 
//	@CrossOrigin(origins = "http://localhost:8081")
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user")
	public ResponseEntity<User1> createUser(@RequestBody User1 user1) {
		try {
			User1 ans= this.userService.createUser(user1);
			return ResponseEntity.status(HttpStatus.CREATED).body(ans);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

}
