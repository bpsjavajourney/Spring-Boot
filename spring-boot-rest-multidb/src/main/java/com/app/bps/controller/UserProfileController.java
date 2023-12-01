package com.app.bps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bps.entity.address.Address;
import com.app.bps.entity.person.Person;
import com.app.bps.model.UserProfile;
import com.app.bps.service.UserProfileService;

/**
 * 
 * UserProfileController
 * 
 * @author parth
 *
 */
@RestController
@RequestMapping("/api/userprofile")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;

	/**
	 * Creates Person
	 * 
	 * @param person
	 * @return Person
	 */
	@PostMapping("/persons")
	public Person insertPerson(@RequestBody Person person) {
		return userProfileService.insertPerson(person);
	}

	/**
	 * Creates Address
	 * 
	 * @param personId
	 * @param address
	 * @return Address
	 */
	@PostMapping("/persons/{id}/address")
	public Address insertAddress(@PathVariable("id") long personId, @RequestBody Address address) {
		return userProfileService.insertAddress(personId, address);
	}

	/**
	 * Provides UserProfile by fetching Person data from person-db and Address data
	 * from address-db
	 * 
	 * @param id
	 * @return UserProfile
	 */
	@GetMapping("/{personId}")
	public ResponseEntity<UserProfile> getUserProfile(@PathVariable("personId") long id) {
		return new ResponseEntity<UserProfile>(userProfileService.getUserProfile(id), HttpStatus.OK);

	}
}
