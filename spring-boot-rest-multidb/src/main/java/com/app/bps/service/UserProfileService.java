package com.app.bps.service;

import com.app.bps.entity.address.Address;
import com.app.bps.entity.person.Person;
import com.app.bps.model.UserProfile;

/**
 *  
 * UserProfileService
 * 
 * @author parth
 *
 */
public interface UserProfileService {

	Person insertPerson(Person person);

	Address insertAddress(long personId, Address address);

	UserProfile getUserProfile(long id);
}
