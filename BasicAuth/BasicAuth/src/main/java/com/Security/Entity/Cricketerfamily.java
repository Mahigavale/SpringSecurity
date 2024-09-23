package com.Security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cricketerfamily {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int familyid;
	
	private int familymemebers;
	private String city;
	private boolean ismarried;
	public int getFamilyid() {
		return familyid;
	}
	public void setFamilyid(int familyid) {
		this.familyid = familyid;
	}
	public int getFamilymemebers() {
		return familymemebers;
	}
	public void setFamilymemebers(int familymemebers) {
		this.familymemebers = familymemebers;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isIsmarried() {
		return ismarried;
	}
	public void setIsmarried(boolean ismarried) {
		this.ismarried = ismarried;
	}
	
	
	
	

}
