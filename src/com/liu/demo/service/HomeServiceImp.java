package com.liu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.liu.demo.dao.UserDao;
import com.liu.demo.entity.UserEntity;

@Service("homeService")
public class HomeServiceImp implements HomeService{

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	public List<UserEntity> getUsers() {
		return userDao.getUser("");
	}

}
