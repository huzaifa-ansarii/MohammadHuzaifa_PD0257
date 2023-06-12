package com.project.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_record")
public class UserCurrentRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cur_rec_id;
	
	private int breakFast;
    private String medicine;
    private int lunch;
	private int dinner;
	@Column(columnDefinition = "DEFAULT 'true'")
	private boolean status=true;
    
    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;
    
    
    public UserCurrentRecord() {
		
	}

	public UserCurrentRecord(int record_id, int breakFast, String medicine, int lunch, int dinner,boolean status) {
		super();
		this.cur_rec_id = record_id;
		this.breakFast = breakFast;
		this.medicine = medicine;
		this.lunch = lunch;
		this.dinner = dinner;
		this.status = true;
		
	}

	public int getCurrentRecord_id() {
		return cur_rec_id;
	}

	public void setCurrentRecord_id(int record_id) {
		this.cur_rec_id = record_id;
	}

	public int getBreakFast() {
		return breakFast;
	}

	public void setBreakFast(int breakFast) {
		this.breakFast = breakFast;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public int getLunch() {
		return lunch;
	}

	public void setLunch(int lunch) {
		this.lunch = lunch;
	}

	public int getDinner() {
		return dinner;
	}

	public void setDinner(int dinner) {
		this.dinner = dinner;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	

	public int getCur_rec_id() {
		return cur_rec_id;
	}

	public void setCur_rec_id(int cur_rec_id) {
		this.cur_rec_id = cur_rec_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserCurrentRecord [cur_rec_id=" + cur_rec_id + ", breakFast=" + breakFast + ", medicine=" + medicine
				+ ", lunch=" + lunch + ", dinner=" + dinner + ", status=" + status + ", disease=" + disease + "]";
	}

	

    
    
    
    
	
	
}
