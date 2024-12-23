package com.hotel.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.extern.slf4j.Slf4j;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roomid;
	private String roomtype;
	private boolean issmokingfriendly;
	private boolean iscooled;
	private boolean hasgallery;
	private String bedsize;
	private String tvsize;
	private boolean hasbathtub;
	
	
	@ManyToOne
	private Hotelentity entity;
	
	
	
	@OneToMany(mappedBy="room")
	@JsonManagedReference
	private  List<Roombooking> booking;
	
	public List<Roombooking> getBooking() {
		return booking;
	}



	public void setBooking(List<Roombooking> booking) {
		this.booking = booking;
	}



	public Room(String roomtype,boolean issmokingfriendly,boolean iscooled,boolean hasgallery,String bedsize,String tvsize,boolean hasbathtub,Hotelentity entity)
	{
		this.bedsize=bedsize;
		this.entity=entity;
		this.hasbathtub=hasbathtub;
		this.hasgallery=hasgallery;
		this.iscooled=iscooled;
		this.roomtype=roomtype;
		this.issmokingfriendly=issmokingfriendly;
		this.tvsize=tvsize;
	}
	


	public int getRoomid() {
		return roomid;
	}


	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}


	public String getRoomtype() {
		return roomtype;
	}


	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}


	public boolean isIssmokingfriendly() {
		return issmokingfriendly;
	}


	public void setIssmokingfriendly(boolean issmokingfriendly) {
		this.issmokingfriendly = issmokingfriendly;
	}


	public boolean isIscooled() {
		return iscooled;
	}


	public void setIscooled(boolean iscooled) {
		this.iscooled = iscooled;
	}


	public boolean isHasgallery() {
		return hasgallery;
	}


	public void setHasgallery(boolean hasgallery) {
		this.hasgallery = hasgallery;
	}


	public String getBedsize() {
		return bedsize;
	}


	public void setBedsize(String bedsize) {
		this.bedsize = bedsize;
	}


	public String getTvsize() {
		return tvsize;
	}


	public void setTvsize(String tvsize) {
		this.tvsize = tvsize;
	}


	public boolean isHasbathtub() {
		return hasbathtub;
	}


	public void setHasbathtub(boolean hasbathtub) {
		this.hasbathtub = hasbathtub;
	}


	public Hotelentity getEntity() {
		return entity;
	}


	public void setEntity(Hotelentity entity) {
		this.entity = entity;
	}
	
	
public Room()
{
	
}
}
