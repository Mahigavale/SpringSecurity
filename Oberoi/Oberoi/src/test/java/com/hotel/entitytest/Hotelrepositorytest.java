package com.hotel.entitytest;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hotel.entity.Hoteladdress;
import com.hotel.entity.Hotelentity;
import com.hotel.repository.Hotelrepo;

@DataJpaTest
public class Hotelrepositorytest {
	
	
	@Autowired
	Hotelrepo repo;
	
	
	@Test
	public void hotel_save_not_null_Test()
	{
		
		//Arrange
		var address=new Hoteladdress("Pune","411057","Deccan");
		
		var hotel=new Hotelentity("Urban","M.Singh",address);
		
		//Act
		
		var hotel2=repo.save(hotel);
		
		//Assert
		Assertions.assertThat(hotel2).isNotNull();
		
		Assertions.assertThat(hotel2.getManager()).isEqualTo(hotel.getManager());
		
		
	}

	
	 @Test
	 public void Find_all_must_be_not_null()
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
			repo.saveAll(hotels);
			
			List<Hotelentity> all_hotels=repo.findAll();
			
			//Assert
			
			Assertions.assertThat(all_hotels.size()).isEqualTo(2);
			Assertions.assertThat(all_hotels).isNotEmpty();
			
	 }
}
























//@DataJpaTest=> it is used to check the tests associated with the DB operations like save etc. It will Only start the specific part 
//of the spring application.rather starting the whole spring application context. used in Unit Testing.
//unit => seperated folders for the test.
