package com.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.rest.modal.Student;
import com.spring.rest.service.RestService;

@RestController
@EnableWebMvc	// Alternate for <mvc:annotation-driven />
@RequestMapping("/api")
public class MyRestController {
	
	@Autowired
	private RestService restService;
	
	@GetMapping("/student")
	private List<Student> getStudentList(){
		// This method will return the list of student in the form of JSON - auto converted by Jackson Databind
		// http://localhost:1040/spring-mvc-rest-revise/api/student
		List<Student> student = new ArrayList<Student>();
		student.add(new Student("101","Saifali","Osmanabad"));
		student.add(new Student("102","Kartik","Pune"));
		student.add(new Student("103","Azar","Aurangabad"));
		
		return student;
	}
	
	@GetMapping("/page")
	private ModelAndView getJspPage() {
		
		
		return new ModelAndView("display");
	}
	
	// http://localhost:1040/spring-mvc-rest-revise/api/student/0
	@GetMapping("/student/{studentId}")
	private Student getStudentById(@PathVariable int studentId) {
		System.out.println(studentId);
		
		List<Student> student = new ArrayList<Student>();
		student.add(new Student("101","Saifali","Osmanabad"));
		student.add(new Student("102","Kartik","Pune"));
		student.add(new Student("103","Azar","Aurangabad"));
		
		return student.get(studentId);
	}
	
	// http://localhost:1040/spring-mvc-rest-revise/api/std/0
	@SuppressWarnings("unused")
	@GetMapping("/std/{studentId}")
	private Student getStudentByIdAsResponseEntity(@PathVariable int studentId) {
		
		ResponseEntity<Student> response = restService.getStudentById(studentId);
		String stdId = response.getBody().getId();
		String stdName = response.getBody().getName();
		String stdAddress = response.getBody().getAddress();
		 
		return new Student();
	}
}
