/**
 * 
 */
package com.spring.practice.springpractice.dao.impl;
import com.spring.practice.springpractice.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author JK
 *
 */
public interface AddressDao extends JpaRepository<Address,Integer> {

}
