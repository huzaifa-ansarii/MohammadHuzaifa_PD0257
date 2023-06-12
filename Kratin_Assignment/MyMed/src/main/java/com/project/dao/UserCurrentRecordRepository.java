package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pojos.UserCurrentRecord;


public interface UserCurrentRecordRepository extends JpaRepository<UserCurrentRecord, Integer> {

	//find all the record by there status
	List<UserCurrentRecord> findAllByStatus(boolean status);
	
}
