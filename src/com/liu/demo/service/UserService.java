package com.liu.demo.service;

import java.util.List;

import com.liu.demo.entity.UserEntity;
import com.liu.demo.model.UserModel;

public interface UserService {
	
	int countAllUser();
	
	int countUser(UserModel user);
	
	List<UserEntity> getUsers(UserModel user);
	
	int createuser(UserModel user);
}