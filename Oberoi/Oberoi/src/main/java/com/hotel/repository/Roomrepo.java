package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.entity.Room;
import com.hotel.entity.Roombooking;

import jakarta.transaction.Transactional;

public interface Roomrepo extends JpaRepository<Room,Integer> {
	
	
//	@Query(value)
//	@Modifying
//	@Transactional
//	public int uodateroom();
	
//	@Query(value="select Roombooking from room where id= :id",nativeQuery=true)
//    public List<Roombooking> findroombokings(@Param("id") int id);	
//
//	@Query(value="select * from roombooking rb where rb.room_roomid = :id", nativeQuery=true)
//	public List<Roombooking> findRoombookingsByRoomId(@Param("id") int id);

	@Query("SELECT rb FROM Roombooking rb WHERE rb.room.roomid = :id")
	List<Roombooking> findRoombookingsByRoomId(@Param("id") int id);



}
