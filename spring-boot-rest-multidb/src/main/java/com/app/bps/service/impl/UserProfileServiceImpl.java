package com.app.bps.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bps.dao.address.AddressRepository;
import com.app.bps.dao.person.PersonRepository;
import com.app.bps.entity.address.Address;
import com.app.bps.entity.person.Person;
import com.app.bps.model.UserProfile;
import com.app.bps.service.UserProfileService;

/**
 * 
 * UserProfileServiceImpl
 * 
 * @author parth
 *
 */

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	PersonRepository personRepository;

	/**
	 * insertPerson into person-db
	 * 
	 * @param person
	 * @return Person
	 */
	@Override
	public Person insertPerson(Person person) {
		return personRepository.save(person);
	}

	/**
	 * insertAddress in the address-db
	 * 
	 * @param address
	 * @return Address
	 */
	@Override
	public Address insertAddress(long personId, Address address) {
		return addressRepository.save(address);
	}

	/**
	 * Provides UserProfile by fetching and combining Person from person-db and
	 * addresses from address-db
	 * 
	 * @param id (person id)
	 * @return UserProfile
	 */
	@Override
	public UserProfile getUserProfile(long id) {
		Optional<Person> person = personRepository.findById(id);
		UserProfile userProfile = null;
		if (person.isPresent()) {
			List<Address> listOfAddresses = addressRepository.findByPersonId(id);

			userProfile = new UserProfile();
			userProfile.setPerson(person.get());
			if (!listOfAddresses.isEmpty())
				userProfile.setAddress(listOfAddresses);
		}

		if (userProfile != null)
			return userProfile;
		else
			throw new RuntimeException("Record " + id + " Not Found");
	}

}
