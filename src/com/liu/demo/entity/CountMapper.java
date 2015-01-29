package com.liu.demo.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CountMapper implements RowMapper<Integer>{
	public Integer mapRow(ResultSet rs, int rowNumber) throws SQLException{
		return rs.getInt(1);
	}
}
