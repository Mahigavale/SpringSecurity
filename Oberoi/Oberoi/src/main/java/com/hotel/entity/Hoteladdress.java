package com.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hoteladdress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int addid;
	public String city;
	public String pincode;
	public String locality;
	
	
	
	public Hoteladdress(String city,String pincode,String locality)
	{
		this.city=city;
		this.pincode=pincode;
		this.locality=locality;
		
	}
	
	public int getAddid() {
		return addid;
	}

	public void setAddid(int addid) {
		this.addid = addid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	
	
	
	public Hoteladdress()
	{
		
	}

}
