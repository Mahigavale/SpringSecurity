package com.Security.demoJWt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Security.demoJWt.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
