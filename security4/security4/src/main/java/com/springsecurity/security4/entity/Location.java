package com.springsecurity.security4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int locationid;
	private String state;
	private String city;
	private String pinocde;
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinocde() {
		return pinocde;
	}
	public void setPinocde(String pinocde) {
		this.pinocde = pinocde;
	}
	
	
}
