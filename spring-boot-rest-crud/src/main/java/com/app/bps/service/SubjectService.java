package com.app.bps.service;

import java.util.List;

import com.app.bps.entity.Subject;

public interface SubjectService {

	public Subject addSubject(Subject subject);
	
	public List<Subject> findAllSubjects();

	public Subject findSubject(long id);

	public void deleteBySubjectId(long id);

}
