package com.app.bps.service;

import java.util.List;

import com.app.bps.entity.Mark;

public interface MarkService {
	
	List<Mark> findAllMarks();	
	Mark findMarkById(int id);	
	Mark createMark(Mark mark);
	Mark updateMark(Mark mark);
	void deleteMark(int id);
	

}
