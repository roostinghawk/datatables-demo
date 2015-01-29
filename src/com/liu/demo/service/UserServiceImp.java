package com.liu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liu.demo.dao.UserDao;
import com.liu.demo.entity.UserEntity;
import com.liu.demo.model.UserModel;

@Service("userService")
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	
	public int countAllUser() {
		return userDao.countAllUser();
	}
	
	public int countUser(UserModel user) {
		return userDao.countUser(user);
	}
	
	public List<UserEntity> getUsers(UserModel user) {
		return userDao.getUsers(user);
	}
	
	public int createuser(UserModel user){
		return userDao.createuser(user);
	}

}
