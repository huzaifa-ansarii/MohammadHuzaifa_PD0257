package com.project.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "disease")
public class Disease {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer disease_id;
	
	private String name;

	public Integer getDisease_id() {
		return disease_id;
	}

	public void setDisease_id(Integer disease_id) {
		this.disease_id = disease_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Disease( String name) {
		
		this.name = name;
	}

	public Disease() {
		
	}

	@Override
	public String toString() {
		return "Disease [disease_id=" + disease_id + ", name=" + name + "]";
	}
	
	
	
}
