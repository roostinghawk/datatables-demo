
package com.liu.demo.dao;

import java.util.List;

import com.liu.demo.entity.UserEntity;

public interface UserDao {
	
	/**
	 * select users.
	 */
	List<UserEntity> getUser(String userFirstName);

	/**
	 * Get user by id.
	 */
	UserEntity getUserById(String id);
	
	/**
	 * Creat user.
	 */
	long createusers(UserEntity user);

}
