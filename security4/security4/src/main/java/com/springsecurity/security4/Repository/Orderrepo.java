package com.springsecurity.security4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.security4.entity.Orders;

@Repository
public interface Orderrepo extends JpaRepository<Orders, Integer> {

}
