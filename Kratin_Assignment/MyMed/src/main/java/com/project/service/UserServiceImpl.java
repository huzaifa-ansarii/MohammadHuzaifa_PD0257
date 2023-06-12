package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserRepository;
import com.project.pojos.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
  //fetching users details
	@Override
	public User getUser(User user) {
         User u = userRepo.findByMobile(user.getMobile());
         System.out.println("inside userservice "+u);
		return u;
	}
	

}
