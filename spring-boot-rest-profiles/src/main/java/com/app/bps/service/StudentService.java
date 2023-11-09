package com.app.bps.service;

import java.util.List;

import com.app.bps.entity.Student;

/**
 * 
 * StudentService
 * 
 * @author parth
 *
 */

public interface StudentService {

	List<Student> findAllStudents();

	Student findStudentById(long id);

	Student createStudent(Student student);

	Student updateStudent(Student student);
	
	void deleteByStudentId(long id);

}
