package com.hotel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Exceptions.Failedtodelete;
import com.hotel.Exceptions.Hotelalreadyexists;
import com.hotel.entity.Hotelentity;
import com.hotel.repository.Hotelrepo;

@Service
public class Hotelservice {
	
	
	@Autowired
	private Hotelrepo repo;
	
	
	public Hotelentity addhotel(Hotelentity entity) throws Hotelalreadyexists
	{
		List<Hotelentity>  all_hotels=repo.findAll();
		
		for(Hotelentity e:all_hotels)
		{
			if(e.getAddress().getPincode()==entity.getAddress().getPincode())
			{
				throw new Hotelalreadyexists();
			}
		}
		return repo.save(entity);
	}
	
	
	public List<Hotelentity> getallhotels() throws Exception
	{
		
		List<Hotelentity> gotten_hotels=repo.findAll();
		
		if(gotten_hotels !=null)
		{
			return gotten_hotels;
		}
		else
		{
			throw new Exception("Something went wrong !");
		}
		
	}
	
	public int deletehotel(int id) throws Failedtodelete
	{
		if(id<0)
		{
			
			throw new Failedtodelete();
		}
		repo.deleteById(id);
		
		return 1;
	}

}
