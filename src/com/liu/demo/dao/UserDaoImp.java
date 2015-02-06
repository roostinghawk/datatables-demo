package com.liu.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	private static String SELECT_USERS= "select id, uid, username, gender, mobile, email, disabled, DATE_FORMAT(createDatetime,'%Y-%m-%d') as createDatetime from user where 1=1";
	
	private static String SELECT_USER_BY_ID= "select id, uid, username, gender, mobile, email, disabled, DATE_FORMAT(createDatetime,'%Y-%m-%d') as createDatetime from user where id=?";
	
	private static String ADD_USER= "insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),?,?,?,?,0,now())";
	
	private static String UPDATE_USER = "update user set disabled=? where id=?";
    
	public int countAllUser() {
		// get count
		int count = this.jdbcTemplate.queryForObject(COUNT_USERS, new CountMapper(), new Object[]{});

		return count;
	}

	public int countUser(UserModel user) {
		// get count
		List<Object> paramsList = new ArrayList<Object>();
		StringBuffer sql = this.bindSqlCondition(COUNT_USERS, user, paramsList);
		int count = this.jdbcTemplate.queryForObject(sql.toString(),
				new CountMapper(),
				paramsList.toArray());

		return count;
	}

	public List<UserEntity> getUsers(UserModel user) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuffer sql = this.bindSqlCondition(SELECT_USERS, user, paramList);
		
		// bind order
		this.bindOrders(sql, user);
		
		// limit to current page
		if(user.getLength() > 0 ){
		    sql.append(" limit " + user.getStart() + "," + user.getLength());
		}

		List<UserEntity> users = this.jdbcTemplate.query(sql.toString(),
				new UserEntityMapper(),
				paramList.toArray());
		
		return users;
	}

	public UserEntity getUserById(String id) {

		List<UserEntity> users = this.jdbcTemplate.query(SELECT_USER_BY_ID,
				new UserEntityMapper(),
				new Object[]{id});
		
		if(users != null && users.size() >= 1){
			return users.get(0);
		}
		
		return null;
	}

	public int createuser(UserModel user) {
		int result = this.jdbcTemplate.update(ADD_USER, new Object[]{
				user.getUsername(), user.getGender(), user.getMobile(), user.getEmail()});
		
		return result;
	}
	
	public int updateUser(int id, int status){
		int result = this.jdbcTemplate.update(UPDATE_USER, new Object[]{status, id});
		
		return result;
	}
	
	// bind search conditions
	private StringBuffer bindSqlCondition(String sql, UserModel user, List<Object> paramList){
		StringBuffer buffer = new StringBuffer(sql);
		
		// gender
		int gender = user.getGender();
		if(gender != -1){
			buffer.append(" and gender = ? ");
			paramList.add(gender);
		}
		
		// search text
		String searchText = user.getSearchText();
		if(searchText != null && searchText != ""){
			boolean isRegexSearch = user.isRegexSearch();
			if(isRegexSearch){
			    buffer.append(" and (username regexp ? or mobile regexp ? or email regexp ?)");
			    paramList.add(searchText);
			    paramList.add(searchText);
			    paramList.add(searchText);
			} else{
			    buffer.append(" and (username like ? or mobile like ? or email like ?)");
			    paramList.add("%" + searchText + "%");
			    paramList.add("%" + searchText + "%");
			    paramList.add("%" + searchText + "%");
			}
		}
		
		return buffer;
	}
	
	private void bindOrders(StringBuffer sqlBuffer, UserModel user){
		// order
		Map<Integer, String> orders = user.getOrders();
		if(orders != null && orders.size() > 0) {
			sqlBuffer.append(" order by ");
			
			for(Map.Entry<Integer, String> order : user.getOrders().entrySet()){
				
				switch(order.getKey()){
				    // user name
					case 0 : {
						sqlBuffer.append(" username ");
						break;
					}
					case 1 : {
						sqlBuffer.append(" gender ");
						break;
					}
					case 2 : {
						sqlBuffer.append(" mobile ");
						break;
					} 
					case 3 : {
						sqlBuffer.append(" email ");
						break;
					} 
					case 4 : {
						sqlBuffer.append(" disabled ");
						break;
					} 			
					case 5 : {
						sqlBuffer.append(" createDatetime ");
						break;
					} 	
				}
				// direction
				sqlBuffer.append(order.getValue() + ",");
			}
			
			// remove the last comma
			sqlBuffer = sqlBuffer.deleteCharAt(sqlBuffer.length() - 1);
		}
		
	}

}
