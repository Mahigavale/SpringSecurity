package com.hotel.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Customlogic.Checkavailability;
import com.hotel.Exceptions.Roomalreadybookedexception;
import com.hotel.entity.Room;
import com.hotel.entity.Roombooking;
import com.hotel.repository.Roombookingrepo;
import com.hotel.repository.Roomrepo;

@Service
public class RoombookingService {
	
	
	@Autowired
	public Roombookingrepo repo;
	
	@Autowired
	public Roomrepo repo2;
	
	
	
//	@Autowired
//	public Checkavailability availability;
	
	public Roombooking bookroom( Roombooking booking) throws Roomalreadybookedexception
	{
		int id=booking.getRoom().getRoomid();
		
		List<Roombooking> bookedtilldates=repo2.findRoombookingsByRoomId(id);
		
		for(Roombooking bk:bookedtilldates)
		{
			Roombooking r=bk;
			
			if(r.getBookedtill().isAfter(booking.getBookedon()))
			{
				throw new Roomalreadybookedexception();
				
			}
		}
		
		return repo.save(booking);
		
		
	}

}
