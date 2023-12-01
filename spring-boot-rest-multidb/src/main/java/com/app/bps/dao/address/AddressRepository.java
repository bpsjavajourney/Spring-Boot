package com.app.bps.dao.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bps.entity.address.Address;

/**
 * 
 * 
 * AddressRepository
 * 
 * @author parth
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByPersonId(long personId);

}
