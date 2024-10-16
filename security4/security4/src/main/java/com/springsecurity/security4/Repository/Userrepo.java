package com.springsecurity.security4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.springsecurity.security4.entity.User;

@Service
public interface Userrepo extends JpaRepository<User, Integer> {

	
	
	@Query(value="select * from User where usermobile= :mb",nativeQuery=true)
	User findbymobile(@Param("mb")String mobile);

}
