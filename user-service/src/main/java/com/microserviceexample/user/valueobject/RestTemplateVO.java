/**
 * 
 */
package com.microserviceexample.user.valueobject;

import com.microserviceexample.user.entity.User;

/**
 * @author JK
 *
 */
public class RestTemplateVO {
	User user;
	Department department;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

}
