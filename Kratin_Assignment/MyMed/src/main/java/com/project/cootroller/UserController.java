package com.project.cootroller;

import java.awt.Taskbar.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.UserRepository;
import com.project.pojos.User;
import com.project.pojos.UserCurrentRecord;
import com.project.service.UserService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//authenticating user by unique mobile Number
	@PostMapping("/auth")
	public ResponseEntity<?> authUser(@Valid @RequestBody User user) {
		System.out.println(user);
		User u = userService.getUser(user);
		  if(user.getPassword().equals(u.getPassword())) {
			  //user is authorized.
		     return new ResponseEntity<>(u,HttpStatus.OK);
		  }
		  else {
			  //if user enter wrong Credentials
			return new ResponseEntity<>("Wrong Credentials",HttpStatus.UNAUTHORIZED);
		  }
	   }
	
	
	}


