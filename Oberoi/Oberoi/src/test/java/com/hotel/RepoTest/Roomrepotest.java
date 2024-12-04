package com.hotel.RepoTest;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotel.Exceptions.Hotelalreadyexists;
import com.hotel.Exceptions.Roomalreadybookedexception;
import com.hotel.Service.Hotelservice;
import com.hotel.Service.RoombookingService;
import com.hotel.entity.Hoteladdress;
import com.hotel.entity.Hotelentity;
import com.hotel.entity.Room;
import com.hotel.entity.Roombooking;
import com.hotel.repository.Roomrepo;

@SpringBootTest
public class Roomrepotest {
	
	
	@Autowired
	public Hotelservice service2;
	
	@Autowired
	public RoombookingService service;
	
	@Autowired
	private Roomrepo repo;
	
	
	@Test
	public void find_room_bookings_by_id() throws Roomalreadybookedexception, Hotelalreadyexists
	{
		var address=new Hoteladdress("Pune","411057","Deccan");
		
		var hotel=new Hotelentity("Urban","M.Singh",address);
		
		service2.addhotel(hotel);
		
		var room=new Room("Delux",true,true,true,"King","52 inches",true,hotel);
		
		//act
		
		
		    LocalDate startDate = LocalDate.of(2024, 11, 20); // Booking start date
	        LocalDate endDate = LocalDate.of(2024, 11, 25);   // Booking end date
		
		Roombooking booking=new Roombooking(startDate, endDate, room);
		
		service.bookroom(booking);
		
		
		System.out.println("ID"+repo.findRoombookingsByRoomId(room.getRoomid()));
		
		Assertions.assertThat(repo.findRoombookingsByRoomId(room.getRoomid()).isEmpty());
	
	}

}
