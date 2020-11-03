package com.spring.rest.service;

import org.springframework.http.ResponseEntity;

import com.spring.rest.modal.Student;

public interface RestService {

	public ResponseEntity<Student> getStudentById(int studentId);
}
