/**
 * 
 */
package com.spring.practice.springpractice.dao.impl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.practice.springpractice.entity.User;
/**
 * @author JK
 *
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {
	public User getUserById(int id);
}
