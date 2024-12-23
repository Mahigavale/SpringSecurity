package com.products.Repository;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.products.Entity.Bottles;


@DataJpaTest
@AutoConfigureTestDatabase
public class BottleRepositoryTest {
	
	
	@Autowired
	private Bottlerepo repo;
	
	
	
	//arrange
	//act
	//assert
	
	@Test
	public void saveBottletest_returns_not_null()
	{
		var Bottle1=new Bottles("Plastic","athletic",23.56f);
		
		var Bottle2=repo.save(Bottle1);
		
		Assertions.assertThat(Bottle2).isNotNull();
	
	}
	
	
	@Test
	public void GetallBottles_must_not_nulltest()
	{
		//arrange
		var bottle3 = new Bottles("Plastic","athletic",45.67f);
		var bottle4=new Bottles("glass","studyy",678.89f);
		var bottle5=new Bottles("glass","leisure",54.65f);
		List<Bottles> listbottles=new ArrayList<Bottles>();
		listbottles.add(bottle4);
		listbottles.add(bottle5);
		listbottles.add(bottle3);
		
		//act
		repo.saveAll(listbottles);
		List<Bottles> listbottles2=repo.findAll();
		
		//asert
		
	   Assertions.assertThat(listbottles2).isNotEmpty();
	   Assertions.assertThat(listbottles2).isNotNull();
	   Assertions.assertThat(listbottles2.size()).isEqualTo(3);
		

	}
	
	
	@Test
	public void update_bottle_must_not_null()
	{
		
		//Arrange
		var b1=new Bottles("electric","leisure",56.67f);
		
		//Act
		repo.save(b1);
		int i=repo.updateprice(78.78f, "electric");
		
		var b2=repo.findById(b1.getId()).get();
		
	
		
		//Assert
		
		Assertions.assertThat(i).isNotEqualTo(0);
		Assertions.assertThat(b1.getPrice()).isNotEqualTo(b2.getPrice());
	}

}
