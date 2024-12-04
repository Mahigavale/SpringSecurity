package com.hotel.Exceptions;

public class Failedtodelete extends Exception {
	
	public Failedtodelete()
	{
		super("something went wrong ! Couldn't delete the hotel !");
	}

}
