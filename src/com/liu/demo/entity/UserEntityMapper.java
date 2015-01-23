package com.liu.demo.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public final class UserEntityMapper implements RowMapper<UserEntity>{
	public UserEntity mapRow(ResultSet rs, int rowNumber) throws SQLException{
		UserEntity entity = new UserEntity();
		entity.setId(rs.getLong("id"));
		entity.setUid(rs.getString("uid"));
		entity.setUsername(rs.getString("username"));
		entity.setGender(rs.getInt("gender"));
		entity.setMobile(rs.getString("mobile"));
		entity.setEmail(rs.getString("email"));
		entity.setDisabled(rs.getInt("disabled"));
		entity.setCreateDatetime(rs.getString("createDatetime"));
		
		return entity;
	}
}