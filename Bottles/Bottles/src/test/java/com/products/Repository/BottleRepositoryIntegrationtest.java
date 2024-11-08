package com.products.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.products.Entity.Bottles;
import com.products.Service.Bottlesservice;

@SpringBootTest
@Transactional
public class BottleRepositoryIntegrationtest {
	
	
	@Autowired
	private Bottlerepo repo;
	
	@Autowired
	private Bottlesservice service;

	
	@Test
	public void save_bottle_real()
	{
		//arrange
		var b=new Bottles("electric","athletic",34.56f);
		
		//act
		var b1=service.addbottle(b);
		
		//assert
		
		Assertions.assertThat(b1).isNotNull();
		
		Assertions.assertThat(b1.getPrice()).isEqualTo(34.56f);
		Assertions.assertThat(b1.getType()).isEqualTo("electric");
		
		Assertions.assertThat(b1.getName()).isEqualTo("athletic");
		
		
		
	}
}
