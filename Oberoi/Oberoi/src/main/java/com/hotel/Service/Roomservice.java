package com.hotel.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Exceptions.HotelnotexistsException;
import com.hotel.Exceptions.SomethingwentwrongException;
import com.hotel.entity.Room;
import com.hotel.repository.Roomrepo;

import lombok.extern.slf4j.Slf4j;

@Service
public class Roomservice {
	
	@Autowired
	private Roomrepo repo;
	
	
	public Room addroom(Room room) throws HotelnotexistsException,Exception
	{

//		System.out.println(room.getEntity());
//		if(room.getEntity().getHotelid() <=0)
//		{
//			//log.error("Exception in adding room !");
//			throw new HotelnotexistsException();
//		}
		 if(room.getEntity()==null )
		{
			throw new Exception("hotel entity is not set for this room !");
		}
		
		return repo.save(room);
	}
	
	
	public Room getroom(int id) throws SomethingwentwrongException
	{
		if(id<=0)
		{
			throw new SomethingwentwrongException();
		}
		
		return repo.findById(id).get();
	}
	
	
}
