package com.app.bps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bps.entity.Student;
import com.app.bps.service.StudentService;

/**
 * 
 * Student Controller/API
 * 
 * @author parth
 *
 */

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> findAllStudents() {

		return new ResponseEntity<List<Student>>(studentService.findAllStudents(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable("id") long id) {

		return new ResponseEntity<Student>(studentService.findStudentById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") long id) {

		studentService.deleteByStudentId(id);

		ResponseEntity.notFound().build();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
}
