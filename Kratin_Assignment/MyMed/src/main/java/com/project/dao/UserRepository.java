package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//fetching users by mobile number
	User findByMobile(String mobile);
}
