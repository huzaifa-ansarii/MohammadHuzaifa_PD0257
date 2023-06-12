package com.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pojos.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Integer> {
	
	//find disease by there name
	Optional<Disease> findByName(String name);
	

}
