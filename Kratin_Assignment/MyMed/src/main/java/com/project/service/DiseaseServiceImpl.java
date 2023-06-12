package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.DiseaseRepository;
import com.project.pojos.Disease;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired
	DiseaseRepository diseaseRepo;
	
	//inserting new disease
	@Override
	public Disease setDisease(Disease d) {
		
		return  diseaseRepo.save(d);
	}

}
