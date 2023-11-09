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

import com.app.bps.entity.Mark;
import com.app.bps.service.MarkService;

/**
 * Mark Controller/API 
 * 
 * @author parth
 *
 */
@RestController
@RequestMapping("/api/marks")
public class MarkController {

	@Autowired
	private MarkService markService;

	@PostMapping
	public ResponseEntity<Mark> createMark(@RequestBody Mark mark) {

		return new ResponseEntity<Mark>(markService.createMark(mark), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Mark> updateMark(@RequestBody Mark mark) {
		
		return new ResponseEntity<Mark>(markService.updateMark(mark), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMark(@PathVariable("id") int id) {

		markService.deleteMark(id);
		ResponseEntity.notFound().build();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mark> findMarkById(@PathVariable("id") int id) {

		return new ResponseEntity<Mark>(markService.findMarkById(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Mark>> findAllMarks() {

		List<Mark> list = markService.findAllMarks();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
