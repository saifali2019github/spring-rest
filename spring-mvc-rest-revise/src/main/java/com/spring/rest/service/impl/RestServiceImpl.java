package com.spring.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.rest.modal.Student;
import com.spring.rest.service.RestService;

@Service
public class RestServiceImpl implements RestService {

	@Override
	public ResponseEntity<Student> getStudentById(int studentId) {
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("101","Saifali","Osmanabad"));
		studentList.add(new Student("102","Kartik","Pune"));
		studentList.add(new Student("103","Azar","Aurangabad"));
		
		return new ResponseEntity<Student>(studentList.get(studentId), HttpStatus.OK);
	}

}
