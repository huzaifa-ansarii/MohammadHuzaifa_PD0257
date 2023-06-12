package com.project.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.DiseaseRepository;
import com.project.dao.UserCurrentRecordRepository;
import com.project.pojos.Disease;
import com.project.pojos.UserCurrentRecord;

@Service

public class UserCorrentRecordImpl implements UserCurrentRecordService {

	@Autowired
	UserCurrentRecordRepository userCurRecord;
	@Autowired
	DiseaseRepository diseaseRepo;

	@Override
	public void setCurrentRecord(UserCurrentRecord record) {
		  //Fetching on going Medicine record for Updating new medicine 
		 List<UserCurrentRecord> allRecord = userCurRecord.findAllByStatus(true);
         //if there is no  on going medicine than add directly
		 if(allRecord.isEmpty() || allRecord.get(0).getDisease().getDisease_id().equals(record.getDisease().getDisease_id())) {
			System.err.println("inside if null");
			
			 userCurRecord.save(record);
		 }
		 
		 else {
			 //else update on going with new medicine
			 for (UserCurrentRecord ucr : allRecord) {
				ucr.setStatus(false);
				userCurRecord.save(ucr);
				
				System.out.println("inside else");
				
			}
			 userCurRecord.save(record);
		 }
		 
    }
     //Fetching all the Record for Display all perivous Record
	@Override
	public List<UserCurrentRecord> getAllRecord() {
		
		return userCurRecord.findAll();
	}
	@Override
	public List<UserCurrentRecord> getAllRecordByStatus(boolean status) {
		
		return userCurRecord.findAllByStatus(status);
	}
	
	

}

