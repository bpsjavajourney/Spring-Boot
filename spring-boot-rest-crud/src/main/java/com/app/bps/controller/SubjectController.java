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

import com.app.bps.entity.Subject;
import com.app.bps.service.SubjectService;

/**
 * 
 * Subject Controller/API
 * 
 * @author parth
 *
 */
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@GetMapping
	public ResponseEntity<List<Subject>> findAllSubjects() {

		return new ResponseEntity<List<Subject>>(subjectService.findAllSubjects(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Subject> findSubject(@PathVariable("id") long id) {

		return new ResponseEntity<Subject>(subjectService.findSubject(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
		return new ResponseEntity<Subject>(subjectService.addSubject(subject), HttpStatus.CREATED);

	}

	@PutMapping
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
		return new ResponseEntity<Subject>(subjectService.addSubject(subject), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSubject(@PathVariable("id") long id) {

		subjectService.deleteBySubjectId(id);

		ResponseEntity.notFound().build();

		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
