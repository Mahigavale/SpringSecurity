package com.hotel.Servicetests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotel.Exceptions.Failedtodelete;
import com.hotel.Exceptions.Hotelalreadyexists;
import com.hotel.Service.Hotelservice;
import com.hotel.entity.Hoteladdress;
import com.hotel.entity.Hotelentity;
import com.hotel.repository.Hotelrepo;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class Hotelservicetest {
	
	
	@Autowired
	private Hotelrepo repo;
	
	@Autowired
	private Hotelservice service;
	
	
	@Test
	public void add_duplicate_hotel_must_throw_an_exception () throws Hotelalreadyexists
	{
		 //Arrange
		
		 var address=new Hoteladdress("Pune","411057","Deccan");
			
			var hotel=new Hotelentity("Urban","M.Singh",address);
			
			var address1=new Hoteladdress("Mumbai","411001","Worli");
			
			var hotel1=new Hotelentity("Urban","V.Iyyer",address1);
			
			List<Hotelentity> hotels=new ArrayList<Hotelentity>();
			hotels.add(hotel);
			hotels.add(hotel1);
			
			//Act
			
				service.addhotel(hotel);
				service.addhotel(hotel1);
		
			
			
			var address2=new Hoteladdress("Mumbai","411001","Worli");
			var hotel2=new Hotelentity("Rural","V. Bhide",address2);
			
			
			
			
			
	Hotelalreadyexists ert=	assertThrows(Hotelalreadyexists.class, ()->
		{
			service.addhotel(hotel2);
		});
		
	
	System.out.println(ert.getMessage());
			
	}
	
	@Test
	public void delete_by_id_must_return_1() throws Exception
	{
		 //Arrange
		 var address=new Hoteladdress("Pune","411057","Deccan");
			
			var hotel=new Hotelentity("Urban","M.Singh",address);
			
			var address1=new Hoteladdress("Mumbai","411001","Worli");
			
			var hotel1=new Hotelentity("Urban","V.Iyyer",address1);
			
//			List<Hotelentity> hotels=new ArrayList<Hotelentity>();
//			hotels.add(hotel);
//			hotels.add(hotel1);
			
			//act
			service.addhotel(hotel);
			service.addhotel(hotel1);
		
			Assertions.assertThat(service.deletehotel(hotel.getHotelid())).isEqualTo(1);
			
			//here we have asserted that the deletion operation of valid id works properly.
	}

	@Test
	public void negative_id_deletion_must_throw_an_exception() throws Hotelalreadyexists
	{
		
		var address=new Hoteladdress("Pune","411057","Deccan");
		
		var hotel=new Hotelentity("Urban","M.Singh",address);
		
		var address1=new Hoteladdress("Mumbai","411001","Worli");
		
		var hotel1=new Hotelentity("Urban","V.Iyyer",address1);
		
//		List<Hotelentity> hotels=new ArrayList<Hotelentity>();
//		hotels.add(hotel);
//		hotels.add(hotel1);
		
		//act
		service.addhotel(hotel);
		service.addhotel(hotel1);
		
		Failedtodelete e=assertThrows(Failedtodelete.class,()->{
			service.deletehotel(-3);
		});
		
		System.out.println(e.getMessage());
	}
	
	
	@Test
	public void findall_must_be_not_null() throws Exception
	{

		var address=new Hoteladdress("Pune","411057","Deccan");
		
		var hotel=new Hotelentity("Urban","M.Singh",address);
		
		var address1=new Hoteladdress("Mumbai","411001","Worli");
		
		var hotel1=new Hotelentity("Urban","V.Iyyer",address1);
		
//		List<Hotelentity> hotels=new ArrayList<Hotelentity>();
//		hotels.add(hotel);
//		hotels.add(hotel1);
		
		//act
		service.addhotel(hotel);
		service.addhotel(hotel1);
		//arrange
		List<Hotelentity> all_hotels=service.getallhotels();
		
		//don't forget to add some hotels in the DB first before trying to retrieve them.
		//because of the transactional , you have to do it everytime.
		//in every method.
		
		//act,assert
		
		
		Assertions.assertThat(all_hotels.size()).isGreaterThan(0);
		Assertions.assertThat(all_hotels).isNotEmpty();
		
		
	}
}
