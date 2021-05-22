/**
 * 
 */
package com.microserviceexample.department.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceexample.department.entity.Department;
import com.microserviceexample.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;


/**
 * @author JK
 *
 */
@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@ResponseBody
	@RequestMapping(value="/",method=RequestMethod.POST,consumes="application/json")
	public Department saveDepartment(@RequestBody Department department) {
		logger.info("inside department controller "+ department.toString());
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		logger.info("inside get method department controller "+departmentId);
		Department dep = departmentService.findDepartmentById(departmentId);
		logger.info(dep.toString());
		return departmentService.findDepartmentById(departmentId);
	}
}
