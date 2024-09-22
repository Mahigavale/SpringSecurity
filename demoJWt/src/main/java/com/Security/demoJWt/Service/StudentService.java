package com.Security.demoJWt.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Security.demoJWt.Entity.Student;
import com.Security.demoJWt.Repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	public String addstudentser(Student student)
	{
		repo.save(student);
		return "Done !";
	}
	
	public List<Student> getallser()
	{
		return repo.findAll();
	}
	
	public String updatestudentser()
	{
		return "Updated !";
	}
	
	

}
