package com.app.bps.model;

import java.util.List;

import com.app.bps.entity.address.Address;
import com.app.bps.entity.person.Person;

import lombok.Data;
/**
 * 
 * UserProfile to provide the combination of both Person and Address entities
 * 
 * @author parth
 *
 */
@Data
public class UserProfile {

	private Person person;
	private List<Address> address;

}
