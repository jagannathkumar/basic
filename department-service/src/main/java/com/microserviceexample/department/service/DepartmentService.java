/**
 * 
 */
package com.microserviceexample.department.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microserviceexample.department.controller.DepartmentController;
import com.microserviceexample.department.entity.Department;
import com.microserviceexample.department.repository.DepartmentRepository;

/**
 * @author JK
 *
 */
@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	/**
	 * @param department
	 * @return
	 */
	public Department saveDepartment(Department department) {
		logger.info("inside service layer post method");
		return departmentRepository.save(department);
	}

	/**
	 * @param departmentId
	 * @return
	 */
	public Department findDepartmentById(long departmentId) {
		logger.info("inside service layer get method");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
