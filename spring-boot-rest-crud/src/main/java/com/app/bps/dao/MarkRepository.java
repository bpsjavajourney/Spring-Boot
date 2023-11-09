package com.app.bps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bps.entity.Mark;

/**
 * MarkRepository
 * 
 * @author parth
 */

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {
	
}
