package com.liu.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.liu.demo.entity.CountMapper;
import com.liu.demo.entity.UserEntity;
import com.liu.demo.entity.UserEntityMapper;
import com.liu.demo.model.UserModel;

@Repository("userDao")
public class UserDaoImp implements UserDao {
	
    @Autowired
    @Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
    
	private static String COUNT_USERS = "select count(1) from user where 1=1";
	
	private static String SELECT_USERS= "select * from user where 1=1";
	
	private static String ADD_USER= "insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),?,?,?,?,0,now())";
    
	public int countAllUser() {
		// get count
		int count = this.jdbcTemplate.queryForObject(COUNT_USERS, new CountMapper(), new Object[]{});

		return count;
	}

	public int countUser(UserModel user) {
		// get count
		Object[] params;
		String sql = this.bindSqlCondition(COUNT_USERS, user, params);
		int count = this.jdbcTemplate.queryForObject(sql,
				new CountMapper(),
				params);

		return count;
	}

	public List<UserEntity> getUsers(UserModel user) {
		String sql = this.bindSqlCondition(SELECT_USERS, user);
		
		// limit to current page
		sql += " limit " + user.getStart() + "," + user.getLength();
		
		List<UserEntity> users = this.jdbcTemplate.query(sql,
				new UserEntityMapper(),
				new Object[]{});
		
		return users;
	}

	public UserEntity getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createuser(UserModel user) {
		int result = this.jdbcTemplate.update(ADD_USER, new Object[]{
				user.getUsername(), user.getGender(), user.getMobile(), user.getEmail()});
		
		return result;
	}
	
	// bind search conditions
	private String bindSqlCondition(String sql, UserModel user, Object[] params){
		StringBuffer buffer = new StringBuffer(sql);
		List<Object> paramList = new ArrayList<Object>();
		
		// search text
		String searchText = user.getSearchText();
		if(searchText != ""){
		    buffer.append(" and (username=? or mobile=? or email=?)");
		    paramList.add(searchText);
		    paramList.add(searchText);
		    paramList.add(searchText);
		}
		
		params = paramList.toArray();
		
		// order
		
		
		
		return buffer.toString();
	}

}
