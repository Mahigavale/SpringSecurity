package com.springsecurity.security4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.security4.entity.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {

}
