/**
 * 
 */
package com.spring.practice.springpractice.service.simpl;


import com.spring.practice.springpractice.entity.User;

/**
 * @author JK
 *
 */
public interface UserService {
	public User saveUser(User user);
	public User showUser(int id);
}
