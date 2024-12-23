package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.entity.Userentity;

public interface Userrepo extends JpaRepository<Userentity, Integer> {
	
	
	@Query(value="select * from Userentity where username= :name",nativeQuery=true)
	public Userentity findbyusername(@Param("name") String name);

}
