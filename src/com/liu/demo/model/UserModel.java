package com.liu.demo.model;

import java.util.HashMap;
import java.util.Map;

public class UserModel {
	private long id;
	private String uid;
	private String username;
	private int gender = -1;
	private String mobile;
	private String email;
	private int disabled;
	private String createDatetime;
	
	private int draw;
	private int start;
	private int length;
	private boolean isRegexSearch;
	private String searchText;
	
	// orders
	private Map<Integer, String> orders = new HashMap<Integer, String>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDisabled() {
		return disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public Map<Integer, String> getOrders() {
		return orders;
	}

	public void setOrders(Map<Integer, String> orders) {
		this.orders = orders;
	}

	public boolean isRegexSearch() {
		return isRegexSearch;
	}

	public void setRegexSearch(boolean isRegexSearch) {
		this.isRegexSearch = isRegexSearch;
	}
}
