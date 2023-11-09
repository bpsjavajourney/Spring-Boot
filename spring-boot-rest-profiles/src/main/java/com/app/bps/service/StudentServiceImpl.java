package com.app.bps.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.bps.dao.StudentRepository;
import com.app.bps.entity.Student;
import com.app.bps.exception.StudentAppException;

/**
 * Student Service provider
 * 
 * @author parth
 *
 */

@Service
public class StudentServiceImpl implements StudentService {

	private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student findStudentById(long id) {
		if (studentRepository.existsById(id)) {
			return studentRepository.findById(id).get();
		} else {

			logger.info("findStudentById(): Student id:" + id + " Not found.", "RECORD_NOT_FOUND");
			throw new StudentAppException("Student id:" + id + " Not found.", "RECORD_NOT_FOUND");
		}
	}

	@Override
	public Student createStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {

		if (studentRepository.existsById(student.getId())) {
			return studentRepository.save(student);
		} else {
			logger.info("updateStudent(): Student id:" + student.getId() + " Not found.", "RECORD_NOT_FOUND");
			throw new StudentAppException("Student id:" + student.getId() + " Not found.", "RECORD_NOT_FOUND");
		}

	}

	@Override
	public void deleteByStudentId(long id) {

		if (studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
		} else {
			logger.info("deleteByStudentId(): Student id:" + id + " Not found.", "RECORD_NOT_FOUND");
			throw new StudentAppException("Student id:" + id + " Not found.", "RECORD_NOT_FOUND");
		}

	}
}
