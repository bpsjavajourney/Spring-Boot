package com.app.bps.dao.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bps.entity.person.Person;

/**
 * * PersonRepository
 * 
 * @author parth
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
