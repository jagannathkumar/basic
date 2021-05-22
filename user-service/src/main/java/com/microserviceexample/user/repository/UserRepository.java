/**
 * 
 */
package com.microserviceexample.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microserviceexample.user.entity.User;
/**
 * @author JK
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	/**
	 * @param userId
	 * @return
	 */
	User findByUserId(Long userId);

}
