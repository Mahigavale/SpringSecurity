package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Actor;

@Repository
public interface Actorrepo extends JpaRepository<Actor, Integer> {

}
