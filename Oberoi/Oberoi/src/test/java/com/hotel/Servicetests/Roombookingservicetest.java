package com.hotel.Servicetests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotel.Exceptions.Hotelalreadyexists;
import com.hotel.Exceptions.Roomalreadybookedexception;
import com.hotel.Service.Hotelservice;
import com.hotel.Service.RoombookingService;
import com.hotel.Service.Roomservice;
import com.hotel.entity.Hoteladdress;
import com.hotel.entity.Hotelentity;
import com.hotel.entity.Room;
import com.hotel.entity.Roombooking;
import com.hotel.repository.Roombookingrepo;
import com.hotel.repository.Roomrepo;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class Roombookingservicetest {

	
	@Autowired
	public Roombookingrepo repo;
	
	@Autowired
	public Roomrepo repo2;
	
	
	@Autowired
	public Roomservice service_room;
	//entities are not treated as Beans
//	@Autowired
//	public Room room;
	
	@Autowired
	public Hotelservice service2;
	
	@Autowired
	public RoombookingService service;
	
	@Test
	public void room_booking_service_test_not_null() throws Hotelalreadyexists, Roomalreadybookedexception
	{
		 var address=new Hoteladdress("Pune","411057","Deccan");
			
			var hotel=new Hotelentity("Urban","M.Singh",address);
			
			service2.addhotel(hotel);
			
			var room=new Room("Delux",true,true,true,"King","52 inches",true,hotel);
			
			//act
			
			
			    LocalDate startDate = LocalDate.of(2024, 11, 20); // Booking start date
		        LocalDate endDate = LocalDate.of(2024, 11, 25);   // Booking end date
			
			Roombooking booking=new Roombooking(startDate, endDate, room);
			
			Roombooking bk=service.bookroom(booking);
			
			Assertions.assertThat(bk).isEqualTo(booking);
			
			
	}
	
	
	
	
	@Test
	public void overlapping_dates_should_throw_an_exception() throws Exception
	{
	
		 var address=new Hoteladdress("Pune","411057","Deccan");
			
			var hotel=new Hotelentity("Urban","M.Singh",address);
			
			service2.addhotel(hotel);
			
			var room=new Room("Delux",true,true,true,"King","52 inches",true,hotel);
			
			service_room.addroom(room);
			
			//act
			
			
			    LocalDate startDate = LocalDate.of(2024, 11, 20); // Booking start date
		        LocalDate endDate = LocalDate.of(2024, 11, 25);   // Booking end date
			
			Roombooking booking=new Roombooking(startDate, endDate, room);
			
			service.bookroom(booking);
			  LocalDate startDate1 = LocalDate.of(2024, 11, 23); // Booking start date
		        LocalDate endDate1 = LocalDate.of(2024, 11, 25);   // Booking end date
		        
		        Roombooking bk1=new Roombooking(startDate1,endDate1,room);
		        
		        
		       Roomalreadybookedexception ex=assertThrows(Roomalreadybookedexception.class, ()->{
		    	   
		    	   service.bookroom(bk1)
;		       });
		       
		       System.out.println(ex.getMessage());
	}
}
