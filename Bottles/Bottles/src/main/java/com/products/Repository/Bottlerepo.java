package com.products.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.products.Entity.Bottles;

import jakarta.transaction.Transactional;

@Repository
public interface Bottlerepo extends JpaRepository<Bottles, Integer> {

	
	@Query(value="update bottles set price= :pr where type= :tp", nativeQuery=true)
	@Modifying
	@Transactional
	public int updateprice(@Param("pr") float pr,@Param("tp") String tp);
	
}
