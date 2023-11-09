package com.app.bps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bps.dao.SubjectRepository;
import com.app.bps.entity.Subject;

/**
 * Subject Service provider
 * 
 * @author parth
 *
 */

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> findAllSubjects() {

		return subjectRepository.findAll();
	}

	@Override
	public Subject findSubject(long id) {

		return subjectRepository.findById(id).get();
	}

	@Override
	public Subject addSubject(Subject subject) {

		return subjectRepository.save(subject);
	}

	@Override
	public void deleteBySubjectId(long id) {

		subjectRepository.deleteById(id);
	}

}
