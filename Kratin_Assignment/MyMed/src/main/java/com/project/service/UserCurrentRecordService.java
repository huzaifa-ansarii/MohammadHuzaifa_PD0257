package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.pojos.User;
import com.project.pojos.UserCurrentRecord;

public interface UserCurrentRecordService {
	
   void setCurrentRecord(UserCurrentRecord record);
   
   List<UserCurrentRecord> getAllRecord();
   List<UserCurrentRecord> getAllRecordByStatus(boolean status);

}


