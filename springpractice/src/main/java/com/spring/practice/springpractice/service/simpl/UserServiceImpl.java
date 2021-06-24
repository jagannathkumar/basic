/**
 * 
 */
package com.spring.practice.springpractice.service.simpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.springpractice.dao.impl.UserDao;
import com.spring.practice.springpractice.entity.User;

/**
 * @author JK
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User showUser(int id) {
		return userDao.getUserById(id);
	}

}
