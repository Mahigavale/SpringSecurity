package com.springsecurity.security4.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.security4.Dto.UserDto;
import com.springsecurity.security4.Repository.Userrepo;
import com.springsecurity.security4.entity.User;

@Service
public class UserService {
	
	@Autowired 
	private Userrepo repo;
	
	public String adduser(User user)
	{
		repo.save(user);
		
		return "Done !";
	}
	
	
	
	public User findbymobile(String mobile)
	{
		return repo.findbymobile(mobile);
	}
	
	public List<UserDto> findallusers()
	{
	
		return repo.findAll().stream().map(this::userdto).collect(Collectors.toList());
	}
	
	
	
	public UserDto userdto(User us)
	{
		
		UserDto dt=new UserDto();
		
		dt.setCity(us.getUserlocation().getCity());
		dt.setPincode(us.getUserlocation().getPinocde());
		dt.setState(us.getUserlocation().getCity());
		dt.setTotalprice(us.getUserOrder().getTotalprice());
		dt.setUseremail(us.getUseremail());
		dt.setUsername(us.getUsername());
		
		return dt;
	}
	

}
