package com.hotel.Customlogic;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.hotel.Exceptions.Roomalreadybookedexception;

@Component
public class Checkavailability {

	
	
	public boolean checkroom(LocalDate newbooking,LocalDate oldbooking) throws Roomalreadybookedexception 
	{
		
		if( newbooking.isAfter(oldbooking))
		{
			return true;
		}
		else
		{
			throw new Roomalreadybookedexception();
		}
	}
}
