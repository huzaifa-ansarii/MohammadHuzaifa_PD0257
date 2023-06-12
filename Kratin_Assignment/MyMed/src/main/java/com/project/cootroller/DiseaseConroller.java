package com.project.cootroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojos.Disease;
import com.project.service.DiseaseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/disease")
public class DiseaseConroller {
	
	@Autowired
	DiseaseService diseaseService;
	
	//adding new disease 
	@PostMapping("/adddisease")
	public ResponseEntity<?> addDisease(@Valid @RequestBody Disease d)
	{
		return new ResponseEntity<>(diseaseService.setDisease(d),HttpStatus.OK);
	}

}
