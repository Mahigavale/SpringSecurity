package com.hotel.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hoteladdress;
import com.hotel.repository.Hoteladdressrepo;

@Service
public class Hoteladdressservice {

	
	@Autowired
	private Hoteladdressrepo repo;
	
	public Hoteladdress addaddress(Hoteladdress address)
	{
		return repo.save(address);
	}
	
}
