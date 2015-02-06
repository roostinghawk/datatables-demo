
package com.liu.demo.dao;

import java.util.List;

import com.liu.demo.entity.UserEntity;
import com.liu.demo.model.UserModel;

public interface UserDao {
	
	/**
	 * count all users.
	 */
	int countAllUser();
	
	/**
	 * count users.
	 */
	int countUser(UserModel user);
	
	/**
	 * select users.
	 */
	List<UserEntity> getUsers(UserModel user);

	/**
	 * Get user by id.
	 */
	UserEntity getUserById(String id);
	
	/**
	 * Creat user.
	 */
	int createuser(UserModel user);
	
	/**
	 * Update user status.
	 */
	int updateUser(int id, int status);

}
