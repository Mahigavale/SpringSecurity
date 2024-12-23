package com.hotel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.entity.Roombooking;

public interface Roombookingrepo extends JpaRepository<Roombooking, Integer> {

	
	
	@Query(value="select * from roombooking where  bookedtill= :ld", nativeQuery=true)
	public List<Roombooking> findallbookings(@Param("ld") LocalDate ld);
}
