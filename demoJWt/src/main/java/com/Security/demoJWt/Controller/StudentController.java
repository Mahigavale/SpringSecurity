package com.Security.demoJWt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.demoJWt.Entity.Student;
import com.Security.demoJWt.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	private StudentService service;
	
	@PostMapping("/add-student")
	public String Add(@RequestBody Student student) throws Exception
	{
		if(student !=null)
		{return service.addstudentser(student);
		}
		else
		{
			throw new Exception("Something went Wrong!");
		}
	}
	
	@GetMapping("/get-all")
	public List<Student> get()
	{
		return service.getallser();
	}
}
