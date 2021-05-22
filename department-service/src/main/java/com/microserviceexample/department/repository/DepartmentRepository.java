/**
 * 
 */
package com.microserviceexample.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microserviceexample.department.entity.Department;

/**
 * @author JK
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

	/**
	 * @param departmentId
	 * @return
	 */
	public Department findByDepartmentId(Long departmentId);

}
