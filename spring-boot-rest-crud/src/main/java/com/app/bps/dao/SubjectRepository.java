package com.app.bps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bps.entity.Subject;

/**
 * 
 * Subject Repository
 * 
 * @author parth
 *
 */

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
