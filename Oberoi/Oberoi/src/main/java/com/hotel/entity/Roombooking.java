package com.hotel.entity;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="roombooking")
public class Roombooking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingid;
	
	@Column(nullable=true)
	private LocalDate bookedon;
	@Column(nullable=true)
	private LocalDate bookedtill;
	
	
	
	@JsonBackReference
	@JoinColumn
	@ManyToOne(cascade =CascadeType.ALL)
	private Room room;



	public int getBookingid() {
		return bookingid;
	}



	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}



	public LocalDate getBookedon() {
		return bookedon;
	}



	public void setBookedon(LocalDate bookedon) {
		this.bookedon = bookedon;
	}



	public LocalDate getBookedtill() {
		return bookedtill;
	}



	public void setBookedtill(LocalDate bookedtill) {
		this.bookedtill = bookedtill;
	}



	public Room getRoom() {
		return room;
	}



	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	int count=0;
	
	public Roombooking(LocalDate bookedon,LocalDate bookedtill,Room room)
	{
		
		
		this.bookedon=bookedon;
		this.bookedtill=bookedtill;
		this.room=room;
		System.out.println("Roombooking :"+(++count));
	}
	

	 // Default constructor (required by Hibernate)
    public Roombooking() {
    }
}
