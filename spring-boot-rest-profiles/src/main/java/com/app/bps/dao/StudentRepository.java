package com.app.bps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bps.entity.Student;

/**
 * 
 * StudentRepository
 * 
 * @author parth
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
