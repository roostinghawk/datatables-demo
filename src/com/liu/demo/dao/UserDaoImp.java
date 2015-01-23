package com.liu.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.liu.demo.entity.UserEntity;
import com.liu.demo.entity.UserEntityMapper;

@Repository("userDao")
public class UserDaoImp implements UserDao {
	
	private static String SELECT_USERS= "select * from user";
	
    @Autowired
    @Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<UserEntity> getUser(String userFirstName) {
		List<UserEntity> users = this.jdbcTemplate.query(SELECT_USERS,
				new UserEntityMapper(),
				new Object[]{});

		return users;
	}

	public UserEntity getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public long createusers(UserEntity user) {
		// TODO Auto-generated method stub
		return 0;
	}
}
