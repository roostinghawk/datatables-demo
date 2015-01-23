package com.liu.demo.service;

import java.util.List;

import com.liu.demo.entity.UserEntity;

public interface HomeService {
	
	List<UserEntity> getUsers();
}