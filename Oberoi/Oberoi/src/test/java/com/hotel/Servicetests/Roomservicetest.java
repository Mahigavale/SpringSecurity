//package com.hotel.Servicetests;
//
//
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.hotel.Exceptions.Hotelalreadyexists;
//import com.hotel.Service.Hotelservice;
//import com.hotel.Service.Roomservice;
//import com.hotel.entity.Hoteladdress;
//import com.hotel.entity.Hotelentity;
//import com.hotel.entity.Room;
//import com.hotel.repository.Hotelrepo;
//import com.hotel.repository.Roomrepo;
//
//import jakarta.transaction.Transactional;
//
//@SpringBootTest
//@Transactional
//public class Roomservicetest {
//	
//	@Autowired
//	public Roomrepo repo;
//	
//	@Autowired
//	public Hotelservice service2;
//	
//	@Autowired
//	public Roomservice service;
//	
//	
//	@Test
//	public void add_room_test_must_not_null() throws Exception
//	{
//		/*
//		public Room(String roomtype,boolean issmokingfriendly,boolean iscooled,boolean hasgallery,String bedsize,String tvsize,boolean hasbathtub,Hotelentity entity)
//		{
//			this.bedsize=bedsize;
//			this.entity=entity;
//			this.hasbathtub=hasbathtub;
//			this.hasgallery=hasgallery;
//			this.iscooled=iscooled;
//			this.roomtype=roomtype;
//			this.issmokingfriendly=issmokingfriendly;
//			this.tvsize=tvsize;
//		}
//		*/
//		//arrange
//		
//        var address=new Hoteladdress("Pune","411057","Deccan");
//		
//		var hotel=new Hotelentity("Urban","M.Singh",address);
//		
//		
//		var room=new Room("Delux",true,true,true,"King","52 inches",true,hotel);
//		
//		//act
//		service2.addhotel(hotel);
//		
//		var room1=service.addroom(room);
//		
//		Assertions.assertThat(room1.getRoomid()).isEqualTo(room.getRoomid());
//		
//		
//		
//	}
//	
//	@Test
//	public void add_room_invalid_hotel_id_must_throw_an_exception() throws Hotelalreadyexists
//	{
//	
//		//Arrange
//		
//        var address=new Hoteladdress("Pune","411057","Deccan");
//		var hotel=new Hotelentity("Urban","M.Singh",address);
//		var room=new Room("Delux",true,true,true,"King","52 inches",true,hotel);
//	
//	//Act
//		
//		
//	assertThrows(HotelnotexistsException.class,()->{
//		service.addroom(room);
//	});
//	}
//}
//
////Transactional is used to roll back the things we did in the in the test purpose.
