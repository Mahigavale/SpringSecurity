package com.security.Auth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.security.Auth.Entity.Dairyadmin;
@Repository
public interface Adminrepo extends JpaRepository<Dairyadmin, String> {
	
	
	@Query(value="select * from dairyadmin where email= :em", nativeQuery=true)
	public Dairyadmin findbyemail(@Param("em") String em);

}
