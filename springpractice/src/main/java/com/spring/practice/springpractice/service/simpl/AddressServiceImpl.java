/**
 * 
 */
package com.spring.practice.springpractice.service.simpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.springpractice.dao.impl.AddressDao;
import com.spring.practice.springpractice.entity.Address;

/**
 * @author JK
 *
 */
@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressDao addressDao;
	@Override
	public Address saveAddress(Address address) {
		return addressDao.save(address);
	}
	
}
