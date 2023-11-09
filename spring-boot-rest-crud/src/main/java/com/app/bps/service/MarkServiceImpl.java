package com.app.bps.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bps.dao.MarkRepository;
import com.app.bps.entity.Mark;
import com.app.bps.exception.StudentAppException;

/**
 * Mark Service provider
 * 
 * @author parth
 *
 */

@Service
public class MarkServiceImpl implements MarkService {

	private final Logger logger = LoggerFactory.getLogger(MarkServiceImpl.class);

	@Autowired
	MarkRepository markRepository;

	@Override
	public List<Mark> findAllMarks() {
		return markRepository.findAll();
	}

	@Override
	public Mark findMarkById(int id) {
		if (markRepository.existsById(id)) {
			return markRepository.findById(id).get();
		} else {
			logger.info("findMarkById(): Mark id:" + id + " Not found.", "RECORD_NOT_FOUND");
			throw new StudentAppException("Mark id:" + id + " Not found.", "RECORD_NOT_FOUND");
		}
	}

	@Override
	public Mark createMark(Mark mark) {
		return markRepository.save(mark);
	}

	@Override
	public Mark updateMark(Mark mark) {
		if (markRepository.existsById(mark.getId())) {
			return markRepository.save(mark);
		} else {
			logger.info("updateMark(): Mark id:" + mark.getId() + " Not found.", "RECORD_NOT_FOUND");
			throw new StudentAppException("Mark id:" + mark.getId() + " Not found.", "RECORD_NOT_FOUND");
		}
	}

	@Override
	public void deleteMark(int id) {

		if (markRepository.existsById(id)) {
			markRepository.deleteById(id);
		} else {
			logger.info("deleteMark(): Mark id:" + id + " Not found.", "RECORD_NOT_FOUND");
			throw new StudentAppException("Mark id:" + id + " Not found.", "RECORD_NOT_FOUND");
		}

	}

}
