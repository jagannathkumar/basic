/**
 * 
 */
package com.microserviceexample.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microserviceexample.user.entity.User;
import com.microserviceexample.user.repository.UserRepository;
import com.microserviceexample.user.valueobject.Department;
import com.microserviceexample.user.valueobject.RestTemplateVO;

/**
 * @author JK
 *
 */
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @param user
	 * @return
	 */
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * @param userId
	 * @return
	 */
	public RestTemplateVO getUserWithDepartment(Long userId) {
		RestTemplateVO vo = new RestTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDepartmentId(),Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
