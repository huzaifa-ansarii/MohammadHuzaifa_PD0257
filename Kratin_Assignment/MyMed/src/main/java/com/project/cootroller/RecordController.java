package com.project.cootroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojos.UserCurrentRecord;
import com.project.service.UserCurrentRecordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/record")
public class RecordController {
	
	@Autowired
	UserCurrentRecordService recordService;
	//adding new record in the users record
	@PostMapping("/addrecord")
	public ResponseEntity<?> addRecord(@Valid @RequestBody UserCurrentRecord record ){
		System.out.println("inside addrecord");
		recordService.setCurrentRecord(record);
		return new ResponseEntity<>("Record Saved", HttpStatus.OK);
	}
	
	//fetching all the record
	@GetMapping("/getrecord")
	public ResponseEntity<?> getRecord(){
		return new ResponseEntity<>(recordService.getAllRecord(),HttpStatus.OK);
	}

}
