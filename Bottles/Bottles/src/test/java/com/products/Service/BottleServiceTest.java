package com.products.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.products.Entity.Bottles;
import com.products.Repository.Bottlerepo;

@ExtendWith(MockitoExtension.class)
@AutoConfigureTestDatabase
public class BottleServiceTest {
	
	@Mock
	private Bottlerepo repo;
	
	@InjectMocks
	private Bottlesservice sevice;
	
	
	@Test
	public void save_bottle_service_not_null()
	{
		//arrange
		var bottle=new Bottles("plastic","ssss",34.45f);
		
		//act
		var bottel2=sevice.addbottle(bottle);
		
		//assert
		
		Assertions.assertThat(bottle).isEqualTo(bottel2);
		
	}
	
	

}
