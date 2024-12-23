package com.hotel.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Hotelentity {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int hotelid;
	public String branch;
	public String manager;
	

	 @JoinColumn
	 @OneToOne(cascade=CascadeType.ALL)
	 public Hoteladdress address;


	 public Hotelentity(String branch,String manager, Hoteladdress address)
	 {
		 this.branch=branch;
		 this.manager=manager;
		 this.address=address;
	 }
	 
	 public Hotelentity()
	 {
		 
	 }
	 
	public int getHotelid() {
		return hotelid;
	}


	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public Hoteladdress getAddress() {
		return address;
	}


	public void setAddress(Hoteladdress address) {
		this.address = address;
	}
	 
	 
	
}
