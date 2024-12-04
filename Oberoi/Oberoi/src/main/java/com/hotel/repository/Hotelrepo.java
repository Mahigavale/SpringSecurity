package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.Hotelentity;

public interface Hotelrepo extends JpaRepository<Hotelentity, Integer> {

}
